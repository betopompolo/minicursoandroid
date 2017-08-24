package unaerp.rp.minicursoandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SalaBatePapoActivity extends AppCompatActivity {
    private Usuario usuario;
    private RecyclerView rvListaMensagem;
    private List<Mensagem> listaMensagem = new ArrayList<>();
    private Timer timerAtualizarMsg = new Timer();
    private final int TEMPO_ATUALIZAR_MSG = 3000; //Tempo em milissegundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala_bate_papo);

        criarUsuario();
        configListaMsgs();
        addMsgs();
    }

    private void addMsgs() {
        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0) {
                listaMensagem.add(new Mensagem(usuario.getNome(),
                        "Eae rapazeada",
                        Calendar.getInstance().getTime().toString()));
            }
            else {
                listaMensagem.add(new Mensagem("Sr. Bugorin", "I s2 Ruby", Calendar.getInstance().getTime().toString()));
            }
        }
        rvListaMensagem.getAdapter().notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        initTimerAtualizarMsg();
    }

    @Override
    protected void onPause() {
//        timerAtualizarMsg.cancel();
        super.onPause();
    }

    private void criarUsuario() {
        //Pegar nome do usuario passado pela tela de login
        String nomeUsuario = getIntent().getStringExtra(LoginActivity.CHAVE_NOME_USUARIO);

        usuario = new Usuario(nomeUsuario);
    }

    private void configListaMsgs() {
        rvListaMensagem = (RecyclerView) findViewById(R.id.rv_lista_mensagem);
        rvListaMensagem.setLayoutManager(new LinearLayoutManager(this));
        rvListaMensagem.setAdapter(new ListaMensagensAdapter(usuario, listaMensagem));
    }

//    private void initTimerAtualizarMsg() {
//        timerAtualizarMsg.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                //TODO Atualizar RecyclerView de mensagens
//                MensagemService mensagemService = RetrofitClient.getClient().create(MensagemService.class);
//                Call<List<Mensagem>> call = mensagemService.getMensagens();
//                call.enqueue(new Callback<List<Mensagem>>() {
//                    @Override
//                    public void onResponse(Call<List<Mensagem>> call, Response<List<Mensagem>> response) {
//                        try {
//                            if(response.body().size() > 0) {
//                                listaMensagem.clear();
//                                listaMensagem.addAll(response.body());
//                            }
//                            Log.d("teste", "onResponse: " + response.body().get(0));
//                            Log.d("teste", "run: atualizou! List size " + response.body().size());
//                        } catch (NullPointerException npe) {
//                            Log.d("teste", "onResponse: response body null");
//                        }
//                    }
//                    @Override
//                    public void onFailure(Call<List<Mensagem>> call, Throwable t) {
//                        Log.d("teste", "onFailure: " + t.getMessage());
//                    }
//                });
//            }
//        }, 0, TEMPO_ATUALIZAR_MSG);
//    }
}
