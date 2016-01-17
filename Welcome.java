package com.irecallapp.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by Research Admin on 12/30/2015.
 */
public class Welcome extends Activity{
    DatabaseHelper help = new DatabaseHelper(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        long id = help.insertRole("1", "Patient");
        id = help.insertRole("2", "Guardian");
        id = help.insertRole("3", "Doctor");

        ImageButton imagev2 = (ImageButton) findViewById(R.id.Loginfirst2);
        imagev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Welcome.this, MainActivity.class);
                startActivity(i);
            }
        });


        ImageButton imagev = (ImageButton)findViewById(R.id.signupfirst2);

        imagev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Welcome.this, Signup.class);
                startActivity(i);
            }
        });



    }


}