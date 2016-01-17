package com.irecallapp.main;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Research Admin on 12/30/2015.
 */
public class Signup extends Activity {
    DatabaseHelper helper = new DatabaseHelper(this);
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        result = (TextView)findViewById(R.id.userSelected);
        result.setEnabled(false);

    }

    TextView result;
    public final void selectUser(View v)
    {
        boolean check = ((RadioButton) v).isChecked();
        switch (v.getId()) {
            case R.id.patient:
                if (check) {
                    result.setText("Patient");
                    result.setEnabled(true);

                    System.out.println("Patient");
                    // c.setRole("1");
                    // helper.insertContact(c);


                } else {
                    result.setEnabled(false);
                }
                break;

            case R.id.guardian:
                if (check) {
                    result.setText("Guardian");
                    result.setEnabled(true);
                    System.out.println("Guardian");
                    // c.setRole("2");
                    // helper.insertContact(c);
                } else {
                    result.setEnabled(false);
                }
                break;

            case R.id.doctor:
                if (check) {
                    result.setText("Doctor");
                    result.setEnabled(true);
                    System.out.println("Doctor");

                    //c.setRole("3");
                    //helper.insertContact(c);
                } else {
                    result.setEnabled(false);
                }

                break;
        }
    }

    public void onButtonClick(View v) {
        if (v.getId() == R.id.signupbtn) {
            EditText txt = (EditText) findViewById(R.id.TFpassword);
            EditText txt2 = (EditText) findViewById(R.id.TFconfirmpassword);
            EditText name = (EditText) findViewById(R.id.TFname);
            EditText email = (EditText) findViewById(R.id.TFemail);
            EditText username = (EditText) findViewById(R.id.TFusername);

            String str = txt.getText().toString();
            String str2 = txt2.getText().toString();
            String namestr = name.getText().toString();
            String emailstr = email.getText().toString();
            String usernamestr = username.getText().toString();
            String what = result.getText().toString();


            if (!str.equals(str2)) {
                Toast.makeText(Signup.this, "Password not match", Toast.LENGTH_LONG).show();
            } else {
                //helper.Searchusername();
                Contact c = new Contact();
                c.setName(namestr);
                c.setEmail(emailstr);
                c.setUname(usernamestr);
                c.setPass(str);
                if(what == "Patient")
                {
                    c.setRole("1");
                }
                else if(what == "Guardian")
                {
                    c.setRole("2");
                }
                else if(what == "Doctor")
                {
                    c.setRole("3");
                }
                System.out.println("The user is : "+what);
                boolean exception = false;
                try {
                    helper.insertContact(c);
                } catch (SQLiteConstraintException w) {
                    exception = true;
                    AlertDialog ad = new AlertDialog.Builder(this).setMessage("Username already taken").setTitle("ERROR!").setCancelable(true).create();
                    ad.show();


                    // Log.d("this", "error");

                }
                if (str.isEmpty() && str2.isEmpty() && namestr.isEmpty() && emailstr.isEmpty() && usernamestr.isEmpty()) {
                    Toast.makeText(Signup.this, "Some requirements are empty!!", Toast.LENGTH_LONG).show();
                } else if (exception == false) {
                    Intent i = new Intent(Signup.this, MainActivity.class);
                    startActivity(i);
                }





            }
        }
    }

}
