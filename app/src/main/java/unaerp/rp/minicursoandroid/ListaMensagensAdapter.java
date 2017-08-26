package unaerp.rp.minicursoandroid;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Beto on 8/11/2017.
 */

public class ListaMensagensAdapter extends RecyclerView.Adapter<ListaMensagensAdapter.ViewHolder> {
    private List<Mensagem> listaMensagens;
    private Usuario usuarioAtual;

    private final int MENSAGEM_ENVIADA = 0;
    private final int MENSAGEM_RECEBIDA = 1;

    public ListaMensagensAdapter(Usuario usuarioAtual, List<Mensagem> listaMensagens){
        this.listaMensagens = listaMensagens;
        this.usuarioAtual = usuarioAtual;
    }

    @Override
    public int getItemViewType(int position) {
        Mensagem mensagem = listaMensagens.get(position);

        if(mensagem.getUsuario().equals(usuarioAtual.getNome())) {
            return MENSAGEM_ENVIADA;
        }
        else {
            return MENSAGEM_RECEBIDA;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        switch (viewType){
            case MENSAGEM_ENVIADA:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_mensagem_enviada, parent, false);
                break;
            case MENSAGEM_RECEBIDA: default:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_mensagem_recebida, parent, false);
                break;
        }

        return new ViewHolder(view);
    }

    //Este método trata cada item da RecyclerView. Os parâmetros são um viewholder
    //(definido na classe ViewHolder abaixo) e a posição do item na lista.
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Mensagem mensagem = listaMensagens.get(position);

        holder.titulo.setText(mensagem.getUsuario());
        holder.corpo.setText(mensagem.getMensagem());
    }

    //Este método retorna o tamanho da lista. Usado para saber, por exemplo, quantas
    //vezes o onBindViewHolder será chamado
    @Override
    public int getItemCount() {
        return listaMensagens.size();
    }

    //Aqui é onde as views de cada item da lista são "vinculadas" com o código
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView titulo;
        TextView corpo;

        ViewHolder(View itemView) {
            super(itemView);

            titulo = (TextView) itemView.findViewById(R.id.titulo_msg);
            corpo = (TextView) itemView.findViewById(R.id.texto_msg);
        }
    }
}
