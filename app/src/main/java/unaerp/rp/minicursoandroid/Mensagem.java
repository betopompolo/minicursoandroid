package unaerp.rp.minicursoandroid;

/**
 * Created by Beto on 8/11/2017.
 */

public class Mensagem {
    private int id;
    private String usuario;
    private String mensagem;

    public Mensagem(String usuario, String mensagem) {
        this.usuario = usuario;
        this.mensagem = mensagem;
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

    @Override
    public String toString() {
        return "nome: " + usuario + "  mensagem: " + mensagem;
    }
}
