package com.naumovskiandrej.downloadapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.AsyncTask;

public class SimulateDownload extends AsyncTask<Void, Integer, Void> {
    private int notificationId = 1;
    private NotificationManager notificationManager;
    private Notification.Builder notificationBuilder;
    private Context context;

    public SimulateDownload(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationBuilder = new Notification.Builder(context)
                .setProgress(100, 0, false)
                .setContentTitle("Downloading...")
                .setSmallIcon(R.drawable.ic_file_download_black_24dp);
        startNotification();
    }

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            for (int i = 1; i <= 2000; i++) {
                Thread.sleep(1);
                if(i % 100 == 0) {
                    publishProgress((int) (i / (float) 2000 * 100));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        updateNotificationProgress(values[0], false);
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        updateNotificationProgress(100, true);
    }

    private void startNotification() {
        notificationManager.notify(notificationId, notificationBuilder.build());
    }

    private void updateNotificationProgress(int progress, boolean isFinished) {
        if(isFinished) {
            notificationBuilder.setContentText("Downloaded");
        } else {
            notificationBuilder.setContentText("");
            notificationBuilder.setProgress(100, progress, false);
        }
        notificationManager.notify(notificationId, notificationBuilder.build());
    }
}