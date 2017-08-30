package unaerp.rp.minicursoandroid;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Beto on 8/22/2017.
 */

public interface MensagemService {
    @GET("mensagem")
    public Call<List<Mensagem>> getMensagens();

    @Headers("Content-Type:application/x-www-form-urlencoded")
    @FormUrlEncoded
    @POST("mensagem")
    public Call<Void> enviarMensagem(@Field("nome") String usuario, @Field("mensagem") String mensagem);
}
