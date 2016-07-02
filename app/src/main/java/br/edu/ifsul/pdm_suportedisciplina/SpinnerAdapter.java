package br.edu.ifsul.pdm_suportedisciplina;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SpinnerAdapter extends ArrayAdapter<String> {


    public SpinnerAdapter(Context context) {
        super(context, android.R.layout.simple_spinner_item);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.activity_spinner_item, parent, false);

        TextView campoDescricao = (TextView) v.findViewById(R.id.txtDescricao);
        ImageView campoIcone = (ImageView) v.findViewById(R.id.imgIcone);

        String descricao = getItem(position);
        campoDescricao.setText(descricao);

        campoDescricao.setTextColor(Color.BLACK);

        if ( descricao.equals("Brasil"))
            campoIcone.setImageResource(R.drawable.br);
        else if ( descricao.equals("Deutschland"))
            campoIcone.setImageResource(R.drawable.de);
        else if ( descricao.equals("England"))
            campoIcone.setImageResource(R.drawable.england);
        else if ( descricao.equals("España"))
            campoIcone.setImageResource(R.drawable.es);
        else if ( descricao.equals("Nippon"))
            campoIcone.setImageResource(R.drawable.jp);



        return v;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = inflater.inflate(R.layout.activity_spinner_item, parent, false);

        TextView campoDescricao = (TextView) v.findViewById(R.id.txtDescricao);
        ImageView campoIcone = (ImageView) v.findViewById(R.id.imgIcone);

        String descricao = getItem(position);
        campoDescricao.setText(descricao);

        campoDescricao.setTextColor(Color.BLACK);

        if ( descricao.equals("Brasil"))
            campoIcone.setImageResource(R.drawable.br);
        else if ( descricao.equals("Deutschland"))
            campoIcone.setImageResource(R.drawable.de);
        else if ( descricao.equals("England"))
            campoIcone.setImageResource(R.drawable.england);
        else if ( descricao.equals("España"))
            campoIcone.setImageResource(R.drawable.es);
        else if ( descricao.equals("Nippon"))
            campoIcone.setImageResource(R.drawable.jp);

        return v;
    }
}
