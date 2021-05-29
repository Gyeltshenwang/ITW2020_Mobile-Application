package com.example.todo23;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Switch;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private static final String ACTION_CUSTOM_BROADCAST= BuildConfig.APPLICATION_ID+".ACTION_CUSTOM_BROADCAST";
    @Override
    public void onReceive(Context context, Intent intent) {


        String intentAction =intent.getAction();

        if(intentAction != null){
            String toastMessage ="";
            switch(intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage ="power connected";
                    break;

                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "power disconnected";
                    break;
                case ACTION_CUSTOM_BROADCAST:
                    toastMessage =" CUSTON_MESSAGE_BRODCASRT RECIEVE";
                    break;





            }
            Toast.makeText(context,toastMessage, Toast.LENGTH_SHORT).show();
        }
       //throw new UnsupportedOperationException("Not yet implemented");
    }
}