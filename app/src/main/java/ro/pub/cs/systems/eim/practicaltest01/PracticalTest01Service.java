package ro.pub.cs.systems.eim.practicaltest01;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;

public class PracticalTest01Service extends Service {

    ProcessingThread processingThread = null;
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

        if (processingThread != null) {
            processingThread.stopThread();
        }
        processingThread = new ProcessingThread(this, left, right);
        processingThread.start();


        return START_STICKY;
    }

}