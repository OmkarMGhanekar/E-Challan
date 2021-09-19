package com.halo.splashloginmotionlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class notify extends AppCompatActivity{
    Button btn_next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notify);

        btn_next=findViewById(R.id.bt_notificaion);
    }

    public void next(View view) {
        String message = "this is a notification";
        NotificationCompat.Builder builder = new NotificationCompat.Builder(notify.this
        )
                .setSmallIcon(R.drawable.ic_baseline_message_24)
                .setContentTitle("New Notification")
                .setContentText(message)
                .setAutoCancel(true);


        Intent a = new Intent(notify.this,notification.class);
        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        a.putExtra("message",message);

        PendingIntent pendingIntent =PendingIntent.getActivity(notify.this,0,a,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);

        NotificationManager notificationManager =(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0,builder.build());
    }

}