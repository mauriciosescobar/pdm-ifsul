package br.edu.ifsul.pdm_suportedisciplina;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.edu.ifsul.pdm_suportedisciplina.servicos.MyService;

public class UtilizandoServicos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilizando_servicos);
    }

    public void onIniciarServico(View v) {

        Intent intent = new Intent(this, MyService.class);

        startService(intent);

    }

    public void onPararServico(View v) {
        // TODO implementar
        Toast.makeText(getApplicationContext(), "Não implementado! :/", Toast.LENGTH_SHORT).show();
    }
}
