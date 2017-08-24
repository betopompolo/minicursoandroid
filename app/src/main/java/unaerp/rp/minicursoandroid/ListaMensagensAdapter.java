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

    public ListaMensagensAdapter(List<Mensagem> listaMensagens){
        this.listaMensagens = listaMensagens;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_lista_mensagens, parent, false);

        return new ViewHolder(view);
    }

    //Este método trata cada item da RecyclerView. Os parâmetros são um viewholder
    //(definido na classe ViewHolder abaixo) e a posição do item na lista.
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Mensagem mensagem = listaMensagens.get(position);

        holder.titulo.setText(mensagem.getNomeUsr());
        holder.corpo.setText(mensagem.getCorpo());

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
