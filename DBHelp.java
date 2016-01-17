package com.irecallapp.main;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Research Admin on 12/30/2015.
 */
public class DBHelp extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "imgdb";
    public static final String TABLE_NAME = "mytable";
    public static final int DATABASE_VERSION = 1;
    private static final String TABLE_CREATE = "create table "+ TABLE_NAME+ "(_id INTEGER primary key autoincrement , "+
            "name text not null, image BLOB)";
    SQLiteDatabase db;
    public DBHelp(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }


    public void onCreate(SQLiteDatabase db)  {
        // Create the table

        db.execSQL(TABLE_CREATE);
        // db.execSQL(TABLE_CREATE2);
        this.db = db;


    }
    //Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Drop older table if existed
        //db.execSQL(DELETE_TABLE);
        //Create tables again
        String query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        this.onCreate(db);

    }
}
