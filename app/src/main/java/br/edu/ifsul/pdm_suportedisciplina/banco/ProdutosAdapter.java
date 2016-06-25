package br.edu.ifsul.pdm_suportedisciplina.banco;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import br.edu.ifsul.pdm_suportedisciplina.R;

/**
 * Created by mauricioescobar on 6/24/16.
 */
public class ProdutosAdapter extends ArrayAdapter<Produto> {

    public ProdutosAdapter(Context context) {
        super(context, android.R.layout.simple_list_item_1);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.activity_lista_produtos_item, parent, false);

        TextView campoCima = (TextView) v.findViewById(R.id.campoCima);
        TextView campoBaixo = (TextView) v.findViewById(R.id.campoBaixo);

        campoCima.setTextColor(Color.BLACK);
        campoBaixo.setTextColor(Color.DKGRAY);

        Produto item = getItem(position);

        campoCima.setText(item.getDescricao());
        campoBaixo.setText(String.format("R$ %s", item.getPreco()));

        return v;
    }
}
