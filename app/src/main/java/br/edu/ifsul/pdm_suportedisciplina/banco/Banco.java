package br.edu.ifsul.pdm_suportedisciplina.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {

    private static final String DB_NAME = "listacompras.db";
    private static final int    DB_VERSION = 1;

    public Banco(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DAOProduto.CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DAOProduto.DROP);
        onCreate(db);
    }
}
