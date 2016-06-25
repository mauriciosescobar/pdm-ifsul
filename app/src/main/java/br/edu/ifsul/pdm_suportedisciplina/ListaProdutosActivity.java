package br.edu.ifsul.pdm_suportedisciplina;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import br.edu.ifsul.pdm_suportedisciplina.banco.DAOProduto;
import br.edu.ifsul.pdm_suportedisciplina.banco.ProdutosAdapter;

public class ListaProdutosActivity extends AppCompatActivity {

    ProdutosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                novoProduto();
            }
        });

        adapter = new ProdutosAdapter(getApplicationContext());
        adapter.addAll(DAOProduto.listar(getApplicationContext()));
        ListView lv = (ListView) findViewById(R.id.lista_produtos);
        lv.setAdapter(adapter);
    }

    private void novoProduto() {
        Intent i = new Intent(getApplicationContext(), AddProdutoActivity.class);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            adapter.clear();
            adapter.addAll(DAOProduto.listar(getApplicationContext()));

            Snackbar.make(findViewById(R.id.lista_produtos),
                    "Produto adicionado", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();

        }
    }
}
