package br.edu.ifsul.pdm_suportedisciplina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(getApplicationContext(), EsteListaCheckBox.class);
       // startActivity(i);

        try {
            String codi = URLEncoder.encode("ácido", "Windows-1252");
            Toast.makeText(getApplicationContext(), codi, Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();;
        }
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
            case R.id.bt_utilizandocheckboxes:
                i = new Intent(getApplicationContext(), UtilizandoCheckBoxesActivity.class);
                break;
            case R.id.bt_utilizandospinner:
                i = new Intent(getApplicationContext(), UtilizandoSpinnerActivity.class);
                break;
            case R.id.bt_servicos_notificacoes:
                i = new Intent(getApplicationContext(), UtilizandoServicos.class);
                break;
            case R.id.bt_utilizandoparametros:
                i = new Intent(getApplicationContext(), UtilizandoParametros.class);
                break;
            case R.id.bt_utilizandoJSON:
                i = new Intent(getApplicationContext(), UtilizandoJSON.class);
                break;
        }

        if ( i != null ) {
            startActivity( i );
        }
    }
}
