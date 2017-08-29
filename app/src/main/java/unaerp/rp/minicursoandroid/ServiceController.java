package unaerp.rp.minicursoandroid;

import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Beto on 8/25/2017.
 */

public class ServiceController {
    private static int lastMessageId = -1;
    
    public static void getMessagesFromService(final RecyclerView recyclerView, final List<Mensagem> messageList){
        if(recyclerView == null || messageList == null)
            return;

        MensagemService mensagemService = RetrofitClient.getClient().create(MensagemService.class);
        Call<List<Mensagem>> call = mensagemService.getMensagens();
        call.enqueue(new Callback<List<Mensagem>>() {
            @Override
            public void onResponse(Call<List<Mensagem>> call, Response<List<Mensagem>> response) {
                try {
                    int qtdeMsg = response.body().size();
                    if(qtdeMsg > 0 && lastMessageId != response.body().get(qtdeMsg-1).getId()) {
                        messageList.clear();
                        messageList.addAll(response.body());
                        recyclerView.getAdapter().notifyDataSetChanged();
                        recyclerView.smoothScrollToPosition(messageList.size()-1);
                        lastMessageId = response.body().get(qtdeMsg-1).getId();
                    }
                    else {
                        Log.d("teste", "onResponse: não atualizou");
                    }
                } catch (NullPointerException npe) {
                    Log.d("teste", "onResponse: response body null");
                }
            }
            @Override
            public void onFailure(Call<List<Mensagem>> call, Throwable t) {
                Log.d("teste", "onFailure: " + t.getMessage());
            }
        });
    }

    public static void sendMessage(final Mensagem mensagem) {
        if(mensagem == null)
            return;

        MensagemService mensagemService = RetrofitClient.getClient().create(MensagemService.class);
        Call<Void> call = mensagemService.enviarMensagem(mensagem.getUsuario(), mensagem.getMensagem());
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                int status = response.code();

                if(status == HttpsURLConnection.HTTP_OK) {
                    Log.d("teste", "onResponse: mensagem enviada");
                }
                else
                    Log.d("teste", "onResponse: mensagem não enviada");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.d("teste", "onFailure: " + t.getMessage());
            }
        });
    }
}
