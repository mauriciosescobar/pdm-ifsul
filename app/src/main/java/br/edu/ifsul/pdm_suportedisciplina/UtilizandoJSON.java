package br.edu.ifsul.pdm_suportedisciplina;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

public class UtilizandoJSON extends Activity {

    // 1. Adicionar a permissao de INTERNET
    // NO arquivo AndroidManifest.xml, adicionar a tag a seguir, antes da TAG <application
    // <uses-permission android:name="android.permission.INTERNET"/>
    // 2. Configurar o Gradle para ele baixar e configurar a biblioteca Volley
    // No arquivo build.gradle, adicionar a linha dentro do bloco dependencies {  }
    // compile 'com.android.volley:volley:1.0.0'
    // Sincronizar o Gradle, caso seja solicitado


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilizando_json);

        final TextView mTextView = (TextView) findViewById(R.id.txtResposta);

        // Instancia  a fila de requisicoes.
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "http://www.w3schools.com/website/Customers_MYSQL.php";

        // Solicita uma String de resposta para a URL informada
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Mostra os primeiros 500 cacacteres da string de resposta

                        // mTextView.setText("A resposta é: "+ response.substring(0,500));

                        StringBuilder dados = new StringBuilder();

                        try {
                            // percorrer o JSON varia para cada exemplo,
                            // pois depende de como os objetos estao organizados hierarquicamente

                            JSONArray raiz = new JSONArray(response);
                            for (int i=0; i < raiz.length(); i++) {
                                JSONObject obj = raiz.getJSONObject(i);
                                dados.append("Nome: " + obj.getString("Name"));
                                dados.append("\n");
                                dados.append("Cidade: " + obj.getString("City"));
                                dados.append("\n");
                                dados.append("País: " + obj.getString("Country"));
                                dados.append("\n\n");
                            }

                            mTextView.setText(dados.toString());
                        }
                        catch(Exception e){
                            mTextView.setText("Erro convertendo JSON " + e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText("Acho que não funcionou! :( :/ <o>");
            }
        });

        // Adiciona a requisicao na fila
        queue.add(stringRequest);
    }
}
