package unaerp.rp.minicursoandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

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
    private EditText txtMensagem;
    private Timer timerAtualizarMsg;
    private final int TEMPO_ATUALIZAR_MSG = 3000; //Tempo em milissegundos
    private int ultimaMsg = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala_bate_papo);

        criarUsuario();
        configListaMsgs();

        txtMensagem = (EditText) findViewById(R.id.txtMensagem);
//        addMsgs();
    }

    private void addMsgs() {
        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0) {
                listaMensagem.add(new Mensagem(usuario.getNome(),
                        "Eae rapazeada"));
            }
            else {
                listaMensagem.add(new Mensagem("Sr. Bugorin", "I s2 Ruby"));
            }
        }
        rvListaMensagem.getAdapter().notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        initTimerAtualizarMsg();
    }

    @Override
    protected void onPause() {
        timerAtualizarMsg.cancel();
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

    private void initTimerAtualizarMsg() {
        timerAtualizarMsg = new Timer();
        timerAtualizarMsg.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                ServiceController.getMessagesFromService(rvListaMensagem, listaMensagem);
            }
        }, 0, TEMPO_ATUALIZAR_MSG);
    }

    public void onBtnEnviarClick(View view) {
        ServiceController.sendMessage(new Mensagem(usuario.getNome(), txtMensagem.getText().toString()));
        txtMensagem.setText("");
    }
}
