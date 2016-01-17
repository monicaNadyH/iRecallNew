package com.irecallapp.main;

/**
 * Created by Macintosh on 1/10/16.
 */
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



// here's our beautiful adapter

public class ArrayAdapterItem extends ArrayAdapter<ContactItem> {

    Context mContext;
    int layoutResourceId;
    ContactItem data[] = null;

    public ArrayAdapterItem(Context mContext, int layoutResourceId, ContactItem[] data) {

        super(mContext, layoutResourceId, data);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.data = data;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /*
         * The convertView argument is essentially a "ScrapView" as described is Lucas post
         * http://lucasr.org/2012/04/05/performance-tips-for-androids-listview/
         * It will have a non-null value when ListView is asking you recycle the row contactlist_itemlayout.
         * So, when convertView is not null, you should simply update its contents instead of inflating a new row contactlist_itemlayout.
         */
        if(convertView==null){
            // inflate the contactlist_itemlayout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        // object item based on the position
        ContactItem objectItem = data[position];

        // get the TextView and then set the text (item name) and tag (item ID) values
        TextView textViewItem = (TextView) convertView.findViewById(R.id.textViewItem);
        textViewItem.setText(objectItem.contactName);
        textViewItem.setTag(objectItem.id);

        return convertView;

    }
}
