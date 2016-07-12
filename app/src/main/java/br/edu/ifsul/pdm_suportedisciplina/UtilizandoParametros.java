package br.edu.ifsul.pdm_suportedisciplina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UtilizandoParametros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilizando_parametros);
    }


    public void onEnviar(View v){

        EditText campoNome = (EditText) findViewById(R.id.campoNome);

        String nome = campoNome.getText().toString();

        Intent mensagem = new Intent(getApplicationContext(), RecebendoParametrosActivity.class);

        mensagem.putExtra("NOME", nome);

        startActivity( mensagem );
    }
}
