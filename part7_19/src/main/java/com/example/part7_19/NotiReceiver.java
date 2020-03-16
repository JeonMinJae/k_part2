package com.example.part7_19;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class NotiReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast t= Toast.makeText(context, "I am NotiReciver", Toast.LENGTH_SHORT);
        t.show();
    }
}
