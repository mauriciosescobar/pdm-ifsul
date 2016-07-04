package br.edu.ifsul.pdm_suportedisciplina.servicos;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.util.StringBuilderPrinter;
import android.widget.Toast;

import br.edu.ifsul.pdm_suportedisciplina.UtilizandoServicos;

public class MyService extends Service {
    private Looper mServiceLooper;
    private ServiceHandler mServiceHandler;

    private final class ServiceHandler extends Handler {
        public ServiceHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            // Aqui deve ser colocado o codigo da logica (TAREFA) que o servico executa, como por exemplo
            // baixar um arquivo, fazer algum processamento, etc.

            // Exemplo: gerar os 10 primeiros números da sequencia de Fibonacci
            int a = 0;
            int b = 1;


            for (int i=2; i < 10; i++){
                int r = a + b;

                geraNotificacao( "Fibonacci: " + r );

                a = b;
                b = r;

                synchronized (this) {
                    try {
                        // aguarda 2 segundos
                        wait(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            // Finaliza o servico retornando o seu ID
            // Fica pronto para executar uma nova TAREFA
            stopSelf(msg.arg1);
        }
    }

    @Override
    public void onCreate() {
        // Nao alterar :D, ao menos que saiba exatamente o que esta fazendo
        // Os comandos abaixo registram e iniciam uma Thread que sera a executora das tarefas recebidas no metodo handleMessage

        HandlerThread thread = new HandlerThread("ServiceStartArguments",
                Process.THREAD_PRIORITY_BACKGROUND);
        thread.start();

        mServiceLooper = thread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Tambem nao alterar

        Toast.makeText(this, "Iniciando o serviço", Toast.LENGTH_SHORT).show();

        Message msg = mServiceHandler.obtainMessage();
        msg.arg1 = startId;
        mServiceHandler.sendMessage(msg);

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // Nao utilizado, por enquanto
        return null;
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "Serviço finalizado!", Toast.LENGTH_SHORT).show();
    }

    public void geraNotificacao(String mensagem) {
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(android.R.drawable.ic_dialog_info)
                        .setContentTitle("Sequência de Fibonacci") // AQUI VAI O TITULO DA NOTIFICACAO
                        .setContentText( mensagem );  // AQUI VAI O CONTEUDO (STRING) A SER EXIBIDO NA NOTIFICACAO

        Intent resultIntent = new Intent(this, UtilizandoServicos.class); // AQUI VAI A ATIVIDADE QUE SERA CHAMADA (se necessario) PELA NOTIFICACAO
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(UtilizandoServicos.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent resultPendingIntent =
                stackBuilder.getPendingIntent(
                        0,
                        PendingIntent.FLAG_UPDATE_CURRENT
                );
        mBuilder.setContentIntent(resultPendingIntent);
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        int idNOtificacao = 1;

        // AQUI GERA DE FATO A NOTIFICACAO
        // O id serve para que voce possa atualizar ou criar um nova notifiacao na bandeja do Android
        mNotificationManager.notify(idNOtificacao, mBuilder.build());
    }
}
