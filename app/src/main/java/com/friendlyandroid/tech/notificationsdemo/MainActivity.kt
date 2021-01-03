package com.friendlyandroid.tech.notificationsdemo

import android.app.PendingIntent
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class MainActivity : AppCompatActivity() {

    val channelId=1023
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val intent = Intent(this,MainActivity::class.java)
        val intent2 = Intent(this,ChatScreen::class.java)
        val pendingIntent:PendingIntent = PendingIntent.getActivity(this,0,intent,0)
        val pendingIntent2:PendingIntent = PendingIntent.getActivity(this,0,intent2,0)
        //Local Notifications
        val builder = NotificationCompat.Builder(this,channelId.toString())
                .setSmallIcon(R.drawable.ic_alert)
                .setContentTitle("My First Notification")
                .setContentText("This is local notification.....")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setStyle(NotificationCompat.BigTextStyle().bigText("Welcome to local notification app........"))
                .setContentIntent(pendingIntent)
                .addAction(android.R.drawable.stat_notify_chat,"Chat",pendingIntent2)
                .setAutoCancel(true)
        with(NotificationManagerCompat.from(this)){
            notify(1,builder.build())
        }

    }
}