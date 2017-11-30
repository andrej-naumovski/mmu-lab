package com.naumovskiandrej.broadcastcounter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mCounterDisplay;
    private int mNumCounts = 0;
    private CounterReceiver mCounterReceiver = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCounterReceiver = new CounterReceiver();
        mCounterDisplay = findViewById(R.id.counterDisplay);
        registerReceiver(mCounterReceiver, new IntentFilter(Intent.ACTION_POWER_CONNECTED));
    }

    class CounterReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            mCounterDisplay.setText(++mNumCounts + "");
        }
    }
}
