package com.irecallapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Research Admin on 12/26/2015.
 */
public class DisplayPatient extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.displaypatient);
        String username = getIntent().getStringExtra("Username");
        TextView tv = (TextView) findViewById(R.id.patientuname);
        tv.setText(username);
        ImageButton btn = (ImageButton) findViewById(R.id.aa);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DisplayPatient.this, Flippy.class);
                startActivity(i);
            }
        });

        ImageButton btn2 = (ImageButton) findViewById(R.id.hang);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DisplayPatient.this, Hangman.class);
                startActivity(i);
            }
        });

    }

}
