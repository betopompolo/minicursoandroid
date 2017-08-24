package unaerp.rp.minicursoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText txtNomeUsr;

    static final String CHAVE_NOME_USUARIO = "nome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Vincular views
        btnLogin = (Button) findViewById(R.id.btn_login);
        txtNomeUsr = (EditText) findViewById(R.id.txt_nome_usr);
    }


    public void onBtnLoginClick(View view) {
        String nomeUsuario = txtNomeUsr.getText().toString();

        if(nomeUsuario.isEmpty()) {
            txtNomeUsr.setError(getString(R.string.error_txt_nome_usr));
        }
        else {
            //Login
            Intent intent = new Intent(this, SalaBatePapoActivity.class);
            intent.putExtra(CHAVE_NOME_USUARIO, nomeUsuario);

            startActivity(intent);
        }
    }
}
