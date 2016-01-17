package com.irecallapp.main;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

/**
 * Created by Research Admin on 12/26/2015.
 */
public class DisplayDoctor extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaydoctor);
        String username = getIntent().getStringExtra("Username");
        TextView tv = (TextView) findViewById(R.id.doctoruname);
        //tv.setText(username);
        tv.setText("ttt");
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
    }
}
