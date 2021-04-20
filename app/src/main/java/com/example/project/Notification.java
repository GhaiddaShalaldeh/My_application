package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class Notification extends AppCompatActivity {
Button notification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
notification=findViewById(R.id.notification);
notification.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
Calendar calendar=Calendar.getInstance();
calendar.set(Calendar.HOUR_OF_DAY,4);
calendar.set(Calendar.MINUTE,48);
calendar.set(Calendar.SECOND,0);
Intent intent=new Intent (getApplicationContext(),Notification_reciever.class);
   PendingIntent pendingIntent=PendingIntent.getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),AlarmManager.INTERVAL_DAY,pendingIntent);


    }
});

    }
}