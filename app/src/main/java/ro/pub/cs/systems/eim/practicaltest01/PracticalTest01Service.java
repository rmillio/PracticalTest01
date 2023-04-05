package ro.pub.cs.systems.eim.practicaltest01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class PracticalTest01Service extends Service {
    public PracticalTest01Service() {
        super();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        double left = Double.parseDouble(intent.getStringExtra(Constants.LEFT_TEXT));
        double right = Double.parseDouble(intent.getStringExtra(Constants.RIGHT_TEXT));

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(System.currentTimeMillis());

        while (true) {
            try {
                Thread.sleep(10000);
                sendBroadcast(new Intent(Constants.actions.get((int) Math.floor(Math.random() * 3)))
                        .putExtra(Constants.SERVICE_LOG,
                                date + " " + (left + right) / 2 + " " + Math.sqrt(left * right)));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}