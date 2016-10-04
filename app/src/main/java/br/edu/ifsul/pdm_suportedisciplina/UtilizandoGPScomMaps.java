package br.edu.ifsul.pdm_suportedisciplina;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class UtilizandoGPScomMaps extends AppCompatActivity {

    // Android Location - para obter mais detalhes
    // https://developer.android.com/guide/topics/location/strategies.html

    // LEIA-ME LEIA-ME :)
    // LEIA-ME LEIA-ME :}
    // LEIA-ME LEIA-ME :]
    // LEIA-ME LEIA-ME :D

    // Configurar o arquivo de manifest adicionando as seguintes permissoes, antes da tag application
    // <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
    // <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
    // Caso sua aplicacao seja para android 5 ou superior, tambem adicionar a linha a seguir
    // <uses-feature android:name="android.hardware.location.gps" />

    private LocationManager locationManager;
    private LocationListener locationListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utilizando_gps_com_maps);
    }

    // Evento de click para botao
    public void onObterGps(View v) {
        // Obtem uma referencia ao servico de localizacao da plataforma
        locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        final TextView campoConteudo = (TextView) findViewById(R.id.txtConteudo);

        // configura o listener para receber as notificacoes
        locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                // Chamado quando uma nova localizacoa e encontrada pelo provedor
                StringBuilder texto = new StringBuilder();
                texto.append("Latitute: "  + location.getLatitude() + "\n");
                texto.append("Longitude: " + location.getLongitude() + "\n");
                texto.append("Altitude: "  + location.getAltitude() + "\n");
                texto.append("Precisão: "  + location.getAccuracy() + " metros.");

                campoConteudo.setText(texto.toString());
            }

            public void onStatusChanged(String provider, int status, Bundle extras) {
            }

            public void onProviderEnabled(String provider) {
            }

            public void onProviderDisabled(String provider) {
            }
        };

        int TEMPO = 0; // tempo minimo entre atualizacoes, em millisegundos
        int DISTANCIA = 0; // distancia minima entre as localizacoes, em metros

        try {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, TEMPO, DISTANCIA, locationListener);
        } catch (SecurityException se) {
            campoConteudo.setText("Ooops. Erro e segurança." + se.getMessage());
        } catch( Exception e) {
            campoConteudo.setText("ERRO grave. " + e.getMessage());
        }
    }

    public void onPararGPS(View v){
        final TextView campoConteudo = (TextView) findViewById(R.id.txtConteudo);

        // Remove o listener parando de receber atualizacoes
        try {
            locationManager.removeUpdates(locationListener);
            campoConteudo.setText("Serviço finalizado");
        } catch(SecurityException se) {
            campoConteudo.setText("Ooops. Erro e segurança. Verifique as permissões. " + se.getMessage());
        } catch( Exception e) {
            campoConteudo.setText("ERRO grave. " + e.getMessage());
        }
    }
}
