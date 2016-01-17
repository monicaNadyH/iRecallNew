package com.irecallapp.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public class HangmanLevel extends AppCompatActivity {

    private void sj()
    {
        Log.d("ds","dksj");
    }
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the text view as the activity layout
        setContentView(R.layout.activity_hangman_level);
    }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void easyStart(View view) {
        Intent intent = new Intent(this, HangmanPlay.class);
        intent.putExtra("level", 0);
        startActivity(intent);
    }



    public void hardStart(View view) {
        Intent intent = new Intent(this, HangmanPlay.class);
        intent.putExtra("level", 1);
        startActivity(intent);
    }


    public void expertStart(View view) {
        Intent intent = new Intent(this, HangmanPlay.class);
        intent.putExtra("level", 2);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }



}
