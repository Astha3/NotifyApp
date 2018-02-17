package com.example.lenovo.notifyapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                PendingIntent pIntent = PendingIntent.getActivities(MainActivity.this, 0 , new Intent[]{intent}, 0);
                Notification noti = new Notification.Builder(MainActivity.this)
                        .setTicker("Ticker Title")
                        .setContentTitle("Content Title")
                        .setContentText("this is here to notify you to to use your app")
                        .setSmallIcon(R.drawable.plus)
                        .addAction(R.drawable.plushopening , "ACTION 1" , pIntent)
                        .addAction(R.drawable.plushopening , "ACTION 2" , pIntent)
                        .setContentIntent(pIntent).getNotification();


                noti.flags = Notification.FLAG_AUTO_CANCEL;

                NotificationManager nm = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                nm.notify(0,noti);
            }
        });
    }
}
