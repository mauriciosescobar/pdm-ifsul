package br.edu.ifsul.pdm_suportedisciplina;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class ChuckNorrisFacts extends Activity {

    private RequestQueue queue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chuck_norris_facts);

        queue = Volley.newRequestQueue(this);

        ImageButton btChuck = (ImageButton) findViewById(R.id.imageButton);
        btChuck.setImageResource(R.drawable.chuck);

        getTotalPiadas();
    }

    private void getTotalPiadas(){
        final TextView campoTotal = (TextView) findViewById(R.id.campoTotal);

        final String url = "http://api.icndb.com/jokes/count";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject raiz = new JSONObject(response);

                            campoTotal.setText(raiz.getString("value") + " piadas!");
                        } catch (Exception e) {
                            campoTotal.setText("Erro convertendo JSON " + e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                campoTotal.setText("Acho que não funcionou! :( :/ <o> " + error.getMessage());
            }
        }
        );

        queue.add(stringRequest);
    }

    public void onChuck(View v) {

        final TextView campoPiada = (TextView) findViewById(R.id.campoPiada);
        final TextView campoID = (TextView) findViewById(R.id.campoID);

        final String url = "http://api.icndb.com/jokes/random";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject raiz = new JSONObject(response);
                            JSONObject value = raiz.getJSONObject("value");

                            campoPiada.setText(Html.fromHtml(value.getString("joke")));
                            campoID.setText("Id da piada: " + value.getString("id"));
                        } catch (Exception e) {
                            campoPiada.setText("Erro convertendo JSON " + e.getMessage());
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                campoPiada.setText("Acho que não funcionou! :( :/ <o> " + error.getMessage());
            }
        }
        );

        queue.add(stringRequest);
    }
}
