package com.naumovskiandrej.downloadapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.job.JobParameters;
import android.app.job.JobService;

public class MyService extends JobService {
    public MyService() {
        super();
    }

    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        new SimulateDownload(getApplicationContext()).execute();
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }


}