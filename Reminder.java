package com.irecallapp.main;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Research Admin on 12/26/2015.
 */
public class Reminder extends Activity{
       /* Button showNot, stopNot, alerBut;
    NotificationManager notification;
    boolean isNotActive = false;
    int notID = 33;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.contactlist_itemlayout.reminder);

        showNot = (Button)findViewById(R.id.showNotificationBut);
        stopNot = (Button) findViewById(R.id.stopNotificationBut);
        alerBut = (Button) findViewById(R.id.alertButton);

    }
    public void showNotification(View view)
    {
        NotificationCompat.Builder notificBuilder = new NotificationCompat.Builder(this).setContentTitle("Reminder").setContentText("New message").setTicker("Alert new message").setSmallIcon(R.drawable.logo);
        Intent i = new Intent(Reminder.this, MoreInfoNotification.class);
        TaskStackBuilder task = TaskStackBuilder.create(this);
        task.addParentStack(MoreInfoNotification.class);
        task.addNextIntent(i);
        PendingIntent pend = task.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
        notificBuilder.setContentIntent(pend);
        notification = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notification.notify(notID, notificBuilder.build());
        isNotActive = true;
    }
    public void stopNotification(View view)
    {
        if(isNotActive)
        {
            notification.cancel(notID);
        }

    }
    public void setAlarm(View view)
    {
    Long alertTime = new GregorianCalendar().getTimeInMillis()+5*1000;
        Intent i = new Intent(Reminder.this, AlertReciever.class);
        AlarmManager alarm = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarm.set(AlarmManager.RTC_WAKEUP, alertTime, PendingIntent.getBroadcast(this,1, i,PendingIntent.FLAG_UPDATE_CURRENT));
    }*/

    DatePicker pickerDate;
    TimePicker pickerTime;
    Button buttonSetAlarm;
    TextView info;

    final static int RQS_1 = 1;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reminder);

        pickerDate = (DatePicker) findViewById(R.id.pickerdate);
        pickerTime = (TimePicker) findViewById(R.id.pickertime);
        info = (TextView) findViewById(R.id.info);

        Calendar now = Calendar.getInstance();
        pickerDate.init(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DAY_OF_MONTH), null);

        pickerTime.setCurrentHour(now.get(Calendar.HOUR_OF_DAY));
        pickerTime.setCurrentMinute(now.get(Calendar.MINUTE));

        buttonSetAlarm = (Button) findViewById(R.id.setalarm);
        buttonSetAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar current = Calendar.getInstance();
                Calendar cal = Calendar.getInstance();
                cal.set(pickerDate.getYear(), pickerDate.getMonth(), pickerDate.getDayOfMonth(), pickerTime.getCurrentHour(), pickerTime.getCurrentMinute(), 00);
                if(cal.compareTo(current) <= 0)
                {
                    Toast.makeText(getApplicationContext(), "Invalid date/ time", Toast.LENGTH_LONG).show();
                }
                else {
                    setAlarm(cal);
                }

            }

        });

    }

    private void setAlarm(Calendar targetCal)
    {
        info.setText("\n\n***\n"+ "Alarm is set at "+ targetCal.getTime()+ "\n"+"***\n");
        Intent intent = new Intent(getBaseContext(), AlertReciever.class);
        PendingIntent pendingintent = PendingIntent.getBroadcast(getBaseContext(),RQS_1, intent,0);
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingintent);
        if(Build.VERSION.SDK_INT >= 14)
        {
            Intent i = new Intent(Intent.ACTION_INSERT);
            i.setData(CalendarContract.Events.CONTENT_URI);
            i.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, targetCal.getTimeInMillis());
            i.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, targetCal.getTimeInMillis());
            //i.putExtra("AllDay", true);
            // i.putExtra("rrule", "FREQ=YEARLY");
            i.putExtra("Title", "A Test Event from android app");
            i.putExtra(CalendarContract.Events.AVAILABILITY, CalendarContract.Events.AVAILABILITY_BUSY);

            startActivity(i);
        }
        else {
            Intent i = new Intent(Intent.ACTION_EDIT);
            i.setType("vnd.android.cursor.item/event");
            i.putExtra("beginTime", targetCal.getTimeInMillis());
            i.putExtra("AllDay", true);
            i.putExtra("rrule", "FREQ=YEARLY");
            i.putExtra("Title", "A Test Event from android app");
            startActivity(i);
        }
    }
}
