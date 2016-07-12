package br.edu.ifsul.pdm_suportedisciplina;

import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RecebendoParametrosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebendo_parametros);

        String nome = getIntent().getStringExtra("NOME");

        TextView campoNome = (TextView) findViewById(R.id.campoNome);

        campoNome.setText( nome );
    }
}
