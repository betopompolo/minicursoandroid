package unaerp.rp.minicursoandroid;

/**
 * Created by Beto on 8/11/2017.
 */

public class Mensagem {
    private int id;
    private String usuario;
    private String mensagem;
    private String data;

    public Mensagem(String usuario, String mensagem, String data) {
        this.usuario = usuario;
        this.mensagem = mensagem;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "nome: " + usuario + "  mensagem: " + mensagem;
    }
}
