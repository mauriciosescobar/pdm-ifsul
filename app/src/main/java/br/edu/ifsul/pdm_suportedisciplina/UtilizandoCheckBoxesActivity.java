package br.edu.ifsul.pdm_suportedisciplina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class UtilizandoCheckBoxesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilizando_check_boxes);
    }

    public void onResumo(View v){
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox);
        CheckBox cb2 = (CheckBox) findViewById(R.id.checkBox2);
        CheckBox cb3 = (CheckBox) findViewById(R.id.checkBox3);
        CheckBox cb4 = (CheckBox) findViewById(R.id.checkBox4);
        CheckBox cb5 = (CheckBox) findViewById(R.id.checkBox5);
        CheckBox cb6 = (CheckBox) findViewById(R.id.checkBox6);

        TextView campoResumo = (TextView) findViewById(R.id.campoResumo);

        String resumo = "";
        if ( cb1.isChecked() )
            resumo += cb1.getText() + "\n";
        if ( cb2.isChecked() )
            resumo += cb2.getText() + "\n";
        if ( cb3.isChecked() )
            resumo += cb3.getText() + "\n";
        if ( cb4.isChecked() )
            resumo += cb4.getText() + "\n";
        if ( cb5.isChecked() )
            resumo += cb5.getText() + "\n";
        if ( cb6.isChecked() )
            resumo += cb6.getText() + "\n";


        campoResumo.setText(resumo);
    }
}
