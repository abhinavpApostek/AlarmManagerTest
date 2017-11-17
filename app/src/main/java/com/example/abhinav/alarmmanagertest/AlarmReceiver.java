package com.example.abhinav.alarmmanagertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Abhinav on 9/22/2017.
 */

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intent1=new Intent(context,AlarmService.class);
        context.startService(intent1);
    }
}
