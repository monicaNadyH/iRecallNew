package com.irecallapp.main;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/** * Created by Research Admin on 12/26/2015.
 */
public class AlertReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // createNotification(context,"Time is up", "5 seconds has passed", "Alert");
        Toast.makeText(context, "Alarm recieved", Toast.LENGTH_LONG).show();

    }
    public void createNotification(Context context, String msg, String msgtxt, String msgAlert)
    {
        PendingIntent notifi = PendingIntent.getActivity(context, 0, new Intent(context, Reminder.class), 0);
        NotificationCompat.Builder notificBuilder = new NotificationCompat.Builder(context).setContentTitle(msg).setContentText(msgtxt).setTicker(msgAlert).setSmallIcon(R.drawable.logo);
        notificBuilder.setContentIntent(notifi);
        notificBuilder.setDefaults(NotificationCompat.DEFAULT_SOUND);
        notificBuilder.setAutoCancel(true);
        NotificationManager notman = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notman.notify(1,notificBuilder.build());
    }
}
