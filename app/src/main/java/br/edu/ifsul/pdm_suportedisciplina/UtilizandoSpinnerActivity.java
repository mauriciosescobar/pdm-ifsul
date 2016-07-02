package br.edu.ifsul.pdm_suportedisciplina;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

public class UtilizandoSpinnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilizando_spinner);

        SpinnerAdapter adapter = new SpinnerAdapter(getApplicationContext());

        adapter.add("Brasil");
        adapter.add("Nippon");
        adapter.add("England");
        adapter.add("España");
        adapter.add("Deutschland");

        Spinner spinner = (Spinner) findViewById(R.id.campoSpinner);

        spinner.setAdapter(adapter);
    }

    public void onSpinner(View v) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Utilizando Spinner");

        Spinner spinner = (Spinner) findViewById(R.id.campoSpinner);
        String item = spinner.getSelectedItem().toString();

        builder.setMessage( item );

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
