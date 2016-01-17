package com.irecallapp.main;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Research Admin on 12/26/2015.
 */
public class Edit extends Activity{
    String uname, pass, new_username, new_password;
    Context ctx = this;
    DatabaseHelper db;

    EditText editunamee, editpasss;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);



        //savedInstanceState = getIntent().getExtras();
        // uname = savedInstanceState.getString("username");
        // pass = savedInstanceState.getString("password");
        Button btn = (Button) findViewById(R.id.update);
        editunamee = (EditText) findViewById(R.id.edituname);
        editpasss = (EditText) findViewById(R.id.editpass);


        final String olduname = MainActivity.username;
        final String oldpass = MainActivity.password;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new_username = editunamee.getText().toString();
                new_password = editpasss.getText().toString();
                //db = new DatabaseHelper(ctx);
                //db.update(db,olduname, oldpass, new_username, new_password);
                // Log.d("SS","call");
                //db.updatedb(db,olduname, oldpass, new_username, new_password );
                // {
                //    Toast.makeText(Edit.this,"Update successfully", Toast.LENGTH_LONG).show();
                // }
                // else {
                //    Toast.makeText(Edit.this,"Update failed", Toast.LENGTH_LONG).show();

                //}
            }
        });

    }
}
