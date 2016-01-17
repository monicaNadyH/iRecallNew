package com.irecallapp.main;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Research Admin on 12/26/2015.
 */

public class Display extends Activity{


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);

        String username = getIntent().getStringExtra("Username");
        TextView tv = (TextView) findViewById(R.id.TVusername);
        tv.setText(username);

        ImageButton btn = (ImageButton) findViewById(R.id.editprofile);
        ImageButton btn2 = (ImageButton) findViewById(R.id.getcontact);
        ImageButton btn3 = (ImageButton) findViewById(R.id.getimages);
        ImageButton btn4 = (ImageButton) findViewById(R.id.remind);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Display.this, Edit.class);
                //startActivity(i);
                startActivityForResult(i,0);

            }
        });



        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor;
                ContentResolver cr = getContentResolver();
                cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null,null, null, null);
                if(cursor.getCount()>0)
                {
                    while (cursor.moveToNext())
                    {
                        String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                        String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                        if(Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0)
                        {
                            Cursor pCur  = cr.query(
                                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" = ?", new String []{id},null
                            );
                            while(pCur.moveToNext())
                            {
                                String phoneNo = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                                //  Toast.makeText(Display.this, "Name: " + name + ", Phpne no: " + phoneNo, Toast.LENGTH_SHORT).show();

                               /* for(int i=0; i< 3 ; i++) {
                                    String str = "Name : " + name[i] + ", phone no.: " + phoneNo[i];
                                    Log.d("Message: ", str);

                                    Intent s = new Intent (Display.this, GetContacts.class);
                                    s.putExtra("Username", str);
                                    startActivity(s);

                                }*/
                                Toast.makeText(Display.this, "Name: " + name + ", Phone no: " + phoneNo, Toast.LENGTH_SHORT).show();



                                // AlertDialog ad = new AlertDialog.Builder(Display.this).setMessage("Name: "+name+ " , Phone no: "+phoneNo).setTitle("Contact details").setCancelable(true).create();
                                //   ad.show();
                                //AlertDialog ad = new AlertDialog.Builder(Display.this).setMessage("Name: "+name+ " , Phone no: "+phoneNo).setTitle("Contact details").setCancelable(true).create();
                                // ad.show();



                            }
                            pCur.close();
                        }

                    }
                }
                // Intent i = new Intent (Display.this, GetContacts.class);
                //  i.putExtra("Username", str);
                // startActivity(i);


            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Display.this, Image.class);
                startActivity(i);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Display.this, Reminder.class);
                startActivity(i);
            }
        });

    }


    public void showContactActivity (View view){
        Intent i = new Intent(Display.this, ContactList.class);
        startActivity(i);
    }
}
