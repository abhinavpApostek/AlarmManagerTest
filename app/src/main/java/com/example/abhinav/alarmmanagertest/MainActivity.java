package com.example.abhinav.alarmmanagertest;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button startAlarm;
    Button stopAlarm;
    PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startAlarm=(Button)findViewById(R.id.button1);
        stopAlarm=(Button)findViewById(R.id.button2);
        Intent alarmIntent = new Intent(MainActivity.this, AlarmReceiver.class);
        pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 1, alarmIntent, 0);
        startAlarm.setOnClickListener(this);
        stopAlarm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.button1) {
            AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            manager.set(AlarmManager.RTC_WAKEUP,1000,pendingIntent);
        }
        else{
            AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            manager.cancel(pendingIntent);
            stopService(new Intent(MainActivity.this, AlarmService.class));
        }
    }
}
