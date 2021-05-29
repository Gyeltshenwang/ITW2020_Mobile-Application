package com.example.todo23;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
private CustomReceiver customReceiver;
private static final String ACTION_CUSTOM_BROADCAST= BuildConfig.APPLICATION_ID+".ACTION_CUSTOM_BROADCAST";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomReceiver customReceiver = new CustomReceiver();
        IntentFilter filter = new IntentFilter();
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        this.registerReceiver( customReceiver,filter);

        LocalBroadcastManager.getInstance(this)
                .registerReceiver(customReceiver,new IntentFilter(ACTION_CUSTOM_BROADCAST));


    }

    @Override
    protected void onDestroy() {


        super.onDestroy();
        this.unregisterReceiver(customReceiver);
        LocalBroadcastManager.getInstance(this)
                .unregisterReceiver(customReceiver);

    }

    public void send(View view) {
        Intent send = new Intent(ACTION_CUSTOM_BROADCAST);
        LocalBroadcastManager.getInstance(this).sendBroadcast(send);
    }
}