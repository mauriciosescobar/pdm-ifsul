package br.edu.ifsul.pdm_suportedisciplina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v){

        int idBotao = v.getId();

        Intent i = null;

        switch (idBotao) {
            case R.id.bt_utilizandobotoes:
                i = new Intent(getApplicationContext(), UtilizandoBotoesActivity.class);
                break;
            case R.id.bt_utilizandoradiobuttons:
                i = new Intent(getApplicationContext(), UtilizandoRadioButtonsActivity.class);
                break;
            case R.id.bt_utilizandoimagens:
                i = new Intent(getApplicationContext(), UtilizandoImagensActivity.class);
                break;
            case R.id.bt_utilizandobanco:
                i = new Intent(getApplicationContext(), ListaProdutosActivity.class);
                break;
        }

        if ( i != null ) {
            startActivity( i );
        }
    }
}
