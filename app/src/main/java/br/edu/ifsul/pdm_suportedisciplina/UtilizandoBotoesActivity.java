package br.edu.ifsul.pdm_suportedisciplina;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class UtilizandoBotoesActivity extends AppCompatActivity {

    ArrayList<String> mensagens = new ArrayList<>();
    int posicao = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilizando_botoes);

        mensagens.add("Oi");
        mensagens.add("Tudo bem?");
        mensagens.add("Como vai você?");
    }

    public void oiClick(View botao) {
        posicao++;
        if (posicao > mensagens.size() - 1)
            posicao = 0;

        String mensagem = mensagens.get(posicao);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Utilizando Botões");

        builder.setMessage( mensagem );

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void onToggleClick(View v) {

        ToggleButton botao = (ToggleButton) findViewById(R.id.toggleButton);

        String mensagem = "";

        if( botao.isChecked() )
            mensagem = "O botão está selecionado";
        else
            mensagem = "O botão NÃO está selecionado";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Utilizando Botões");

        builder.setMessage( mensagem );

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
