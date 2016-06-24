package br.edu.ifsul.pdm_suportedisciplina;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class UtilizandoRadioButtons extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilizando_radio_buttons);
    }

    public void onCheckClick (View v) {

        RadioButton clicado = (RadioButton) v;

        exibeAlerta ( "Você clicou em " + clicado.getText() );
    }

    public void onValida (View v) {

        RadioGroup group = (RadioGroup) findViewById(R.id.radioGroup);

        int idSelecionado = group.getCheckedRadioButtonId();

        RadioButton selecionado = (RadioButton) findViewById(idSelecionado);

        exibeAlerta("Radio selecionado: " + selecionado.getText());
    }

    private void exibeAlerta(String mensagem) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Utilizando Botões");

        builder.setMessage( mensagem );

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
