package com.irecallapp.main;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Research Admin on 12/26/2015.
 */
public class DatabaseHelper extends SQLiteOpenHelper  {
    private static final int datebase_version = 1;
    private static final String Database_Name = "Users.db";
    private static final String Table_Name = "User";
    private static final String Column_ID = "id";
    private static final String Column_name = "name";
    private static final String Column_email = "email";
    private static final String Column_username = "uname";
    private static final String Column_pass = "pass";
    private static final String Column_role = "Role";


    private static final String Table_Name2 = "Role";
    private static final String Column_ID2 = "id";
    private static final String Column_role2 = "role";


    SQLiteDatabase db;
    private static final String TABLE_CREATE = "create table "+ Table_Name+ "(id integer not null , "+
            "name text not null, email text not null, uname text primary key not null, pass text not null, Role text)";

    private static final String TABLE_CREATE2 = "create table "+ Table_Name2+ "(id integer primary key not null , "+ "role text not null)";

    public DatabaseHelper(Context context) {
        super(context, Database_Name, null, datebase_version);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        db.execSQL(TABLE_CREATE2);
        this.db = db;

    }

    public long insertRole(String id, String role)
    {
        db = this.getWritableDatabase();
        ContentValues val = new ContentValues();
        val.put(Column_ID2, id);
        val.put(Column_role2, role);
        return db.insert(Table_Name2, null, val);
    }
    public void insertContact(Contact c) {



        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String query = "Select * from "+ Table_Name;
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();

        values.put(Column_ID, count);
        values.put(Column_name, c.getName());
        values.put(Column_email, c.getEmail());
        values.put(Column_username, c.getUname());
        values.put(Column_pass, c.getPass());
        values.put(Column_role, c.getRole());

        db.insertOrThrow(Table_Name, null, values);


        //  long rows=db.insertWithOnConflict(Table_Name, null,  values,SQLiteDatabase.CREATE_IF_NECESSARY);
        // System.out.print(rows);
        // Log.d("kkkkkkkkkk",""+ rows);
        db.close();


    }

    public String searchrole(String uname, String pass)
    {
        db = this.getReadableDatabase();
        String query = "select uname, pass, Role from "+ Table_Name;
        Cursor cursor= db.rawQuery(query, null);
        String a,b,c;
        c = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);
                b = cursor.getString(1);
                c = cursor.getString(2);


                if(a.equals((uname)) && b.equals(pass)){
                    c = cursor.getString(2);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return c;
    }

    public String searchpass(String uname)
    {
        db = this.getReadableDatabase();
        String query = "select uname, pass,Role from "+ Table_Name;
        Cursor cursor= db.rawQuery(query, null);
        String a,b,c;
        b = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);
                b = cursor.getString(1);
                c = cursor.getString(2);


                if(a.equals((uname))){
                    b = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return b;
    }


    public String searchuname(String pass)
    {
        db = this.getReadableDatabase();
        String query = "select uname, pass, Role from "+ Table_Name;
        Cursor cursor= db.rawQuery(query, null);
        String a,b,c;
        a = "not found";
        if(cursor.moveToFirst())
        {
            do{
                a = cursor.getString(0);
                b = cursor.getString(1);
                c = cursor.getString(2);


                if(b.equals((pass))){
                    a = cursor.getString(0);
                    break;
                }
            }while(cursor.moveToNext());
        }
        return a;
    }


    public void Searchusername()
    {
        db = this.getReadableDatabase();
        String query = "select uname from "+ Table_Name;

        Cursor c = db.rawQuery(query,null);
        Cursor t = db.rawQuery(query,null);
        int iRow = c.getColumnIndex(Column_username);
        int sRow = t.getInt(iRow+1);
        String a, b;
        // for(c.moveToNext(); !c.isAfterLast(); c.moveToNext())
        // {
        a = c.getString(iRow);
        b = c.getString(sRow);
        if(a.equals(b))
        {
            //  Log.println(Integer.parseInt(null), null, "username is taken!");

        }

        //  }
    }

    public void updatedb(DatabaseHelper db, String uname, String pass, String nname, String npass)
    {

        //ContentValues args = new ContentValues();
        // args.put(Column_name, name);
        //args.put(Column_pass, pass);
        //getWritableDatabase().update(Table_Name, args, Column_ID + "=?" , null) ;

        SQLiteDatabase sql = db.getWritableDatabase();
        String selection = Column_username +" LIKE ? AND "+Column_pass +" LIKE ?";
        String args[] = {uname, pass};
        ContentValues values =new ContentValues();
        values.put(Column_username, nname);
        values.put(Column_pass, npass);
        //  try {
        sql.update(Table_Name, values, selection, args);
        // sql.update(Table_Name, values,Profile_Name_for_weekly +" = ?"+profilename, new String[] {profilename});
        //    Log.d("Tag", "Yay");
        //  }
        //  catch (android.database.SQLException sq)
        //  {
        //      Log.d("Tag","This");
        //  }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS" + Table_Name;
        String query2 = "DROP TABLE IF EXISTS" + Table_Name2;

        db.execSQL(query);
        db.execSQL(query2);
        this.onCreate(db);
    }
}


