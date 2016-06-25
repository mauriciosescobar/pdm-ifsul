package br.edu.ifsul.pdm_suportedisciplina;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.edu.ifsul.pdm_suportedisciplina.banco.DAOProduto;
import br.edu.ifsul.pdm_suportedisciplina.banco.Produto;

public class AddProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_produto);
    }

    public void onCadastrar(View v) {
        EditText campoDescricao = (EditText) findViewById(R.id.campoDescricao);
        EditText campoPreco = (EditText) findViewById(R.id.campoPreco);

        try {
            String descricao = campoDescricao.getText().toString();
            float preco = Float.parseFloat(campoPreco.getText().toString());

            Produto p = new Produto(-1, descricao, preco);

            DAOProduto.cadastrar(getApplicationContext(), p);

            setResult(RESULT_OK);
            finish();
        } catch (Exception e) {
            setResult(RESULT_CANCELED);
            finish();
        }
    }
}
