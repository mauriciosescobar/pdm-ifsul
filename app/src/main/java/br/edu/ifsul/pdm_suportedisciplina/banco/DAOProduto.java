package br.edu.ifsul.pdm_suportedisciplina.banco;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class DAOProduto {

    static final String CREATE =
            "CREATE TABLE produtos (_id INTEGER PRIMARY KEY AUTOINCREMENT, descricao TEXT, preco REAL);";

    static final String DROP = "DROP TABLE IF EXISTS produtos;";

    public static void cadastrar(Context c, Produto novoProduto){
        Banco b = new Banco(c);

        SQLiteDatabase db = b.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("descricao", novoProduto.getDescricao());
        cv.put("preco", novoProduto.getPreco());

        db.insert("produtos", null, cv);

        Log.d("PDM", "Produto inserido");

        db.close();
    }

    public static ArrayList<Produto> listar(Context c){
        ArrayList<Produto> lista = new ArrayList<>();

        SQLiteDatabase db = new Banco(c).getReadableDatabase();

        final String TABELA         = "produtos";
        final String [] COLUNAS     = {"descricao", "preco"};
        final String ORDER_BY       = "descricao";
        final String WHERE          = null;
        final String [] WHERE_PARAM = null;

        Cursor cursor = db.query(TABELA, COLUNAS, WHERE, WHERE_PARAM, null, null, ORDER_BY);

        while ( cursor.moveToNext() ){
            Produto p = new Produto(cursor.getString(0), cursor.getFloat(1));
            lista.add(p);
        }

        db.close();

        return lista;
    }
}
