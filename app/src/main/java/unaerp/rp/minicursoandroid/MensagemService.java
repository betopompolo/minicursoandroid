package unaerp.rp.minicursoandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Beto on 8/22/2017.
 */

public interface  MensagemService {
    @GET("mensagens")
    public Call<List<Mensagem>> getMensagens();
}
