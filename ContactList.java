package com.irecallapp.main;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

public class ContactList extends AppCompatActivity {

    protected Cursor contactCursor;
    private ContactItem[] contactItems;
    private  ContentResolver cr;

    private TextView contactCountLabel;
    private ListView contactListViewItems;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_list);
        cr = getContentResolver();

        contactCountLabel = (TextView) findViewById(R.id.contactCountLabel);
        contactListViewItems = (ListView) findViewById(R.id.contactListView);

        ContactHelper contactHelper = new ContactHelper();
        getContacts(contactHelper, cr);

        contactCountLabel.setText("Contact count: " + contactCursor.getCount());
        contactItems = new ContactItem[contactCursor.getCount()];

        parseContactCursor();

        // our adapter instance
        ArrayAdapterItem adapter = new ArrayAdapterItem(this, R.layout.contactlist_itemlayout, contactItems);

        // create a new ListView, set the adapter and item click listener
        //listViewItems = new ListView(this);
        contactListViewItems.setAdapter(adapter);
        //contactListViewItems.setOnItemClickListener(new OnItemClickListenerListViewItem());

    }


    private void getContacts (ContactHelper contactHelper, ContentResolver cr){


        contactCursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        //contactCursor.moveToFirst();

        //Log.d("Cursor: ", DatabaseUtils.dumpCursorToString(contactCursor));
    }

    private void parseContactCursor() {

        int i = 0;

        //Log.d("Cursor: ", DatabaseUtils.dumpCursorToString(cursor));


        if (contactCursor.getCount() > 0) {

            while (contactCursor.moveToNext()) {
                String id = contactCursor.getString(contactCursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name = contactCursor.getString(contactCursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                String phoneNo = "";




                if(Integer.parseInt(contactCursor.getString(contactCursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0)
                {
                    Cursor pCur  = cr.query(
                            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" = ?", new String []{id},null
                    );
                    while(pCur.moveToNext())
                    {
                         phoneNo = pCur.getString(pCur.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));

                    }
                    pCur.close();
                }


                ContactItem item = new ContactItem(id, name, phoneNo);
                contactItems[i] = item;

                i++;
            }

            for (int j = 0; j < i; j++){

                Log.d("Tag", "Name: " + contactItems[j].contactName + ", Phpne no: " + contactItems[j].phoneNumber + ", ID: " + contactItems[j].id);

            }

        }


    }

}
