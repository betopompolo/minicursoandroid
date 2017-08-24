package unaerp.rp.minicursoandroid;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Beto on 8/11/2017.
 */

public class Mensagem {
    @SerializedName("name") private String nomeUsr;
    @SerializedName("menssage") private String corpo;
    @SerializedName("date") private String data;

    public Mensagem(String nomeUsr, String corpo, String data) {
        this.nomeUsr = nomeUsr;
        this.corpo = corpo;
        this.data = data;
    }

    public String getNomeUsr() {
        return nomeUsr;
    }

    public void setNomeUsr(String nomeUsr) {
        this.nomeUsr = nomeUsr;
    }

    public String getCorpo() {
        return corpo;
    }

    public void setCorpo(String corpo) {
        this.corpo = corpo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "nome: " + nomeUsr + "  mensagem: " + corpo;
    }
}
