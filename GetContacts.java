package com.irecallapp.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Research Admin on 12/30/2015.
 */
public class GetContacts extends Activity {

    //ListView lv;
    // Cursor cursor;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getcontacts);


        String username = getIntent().getStringExtra("Username");
        TextView tv = (TextView) findViewById(R.id.info);
        tv.setText(username);



      /*  cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null,null);
        startManagingCursor(cursor);
        String[] from = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER, ContactsContract.CommonDataKinds.Phone._ID};
        int[] to = {android.R.id.text1, android.R.id.text2};
        SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(this, android.R.contactlist_itemlayout.simple_expandable_list_item_2, cursor, from,to);
        setListAdapter(listAdapter);
        lv = getListView();
        lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

*/

    }
}
