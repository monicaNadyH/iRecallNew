package com.irecallapp.main;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.ByteArrayOutputStream;

/**
 * Created by Research Admin on 12/26/2015.
 */
public class Image extends Activity implements View.OnClickListener  {
    private ImageView imageview=null;
    private Button btninsert=null;
    private Button btnretrive=null;
    private Button btnget=null;
    private MyDataBase mdb=null;
    private SQLiteDatabase db=null;
    private Cursor c=null;
    private byte[] img=null;
    private byte[] img2 = null;
    private static final String DATABASE_NAME = "ImageDb.db";
    public static final int DATABASE_VERSION = 1;
    private static final int SELECT_PICTURE = 1;
    private String selectedImagePath;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image);
        btninsert=(Button)findViewById(R.id.button_insert);
        btnretrive= (Button)findViewById(R.id.button_retrieve);
        btnget = (Button) findViewById(R.id.get_image);

        imageview= (ImageView)findViewById(R.id.imageView_image);
        imageview.setImageResource(0);
        btninsert.setOnClickListener(this);
        btnretrive.setOnClickListener(this);
        mdb=new MyDataBase(getApplicationContext(), DATABASE_NAME,null, DATABASE_VERSION);


        final Bitmap b= BitmapFactory.decodeResource(getResources(), R.drawable.logo);
        // BitmapFactory.Options options = new BitmapFactory.Options();
        // options.inJustDecodeBounds = true;
        // Bitmap b1=BitmapFactory.decodeResource(getResources(),R.id.imageView_image, options);


        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        b.compress(Bitmap.CompressFormat.PNG, 100, bos);
        img=bos.toByteArray();
        db=mdb.getWritableDatabase();
        btnget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"),SELECT_PICTURE);
            }
        });
    }



    public void onClick(View arg0) {

        if(btninsert==arg0)
        {


            ContentValues cv = new ContentValues();
            cv.put("image", img.length);
            db.insert("tableimage", null, cv);
            Toast.makeText(this, "inserted successfully", Toast.LENGTH_SHORT).show();


        }
        else if(btnretrive==arg0)
        {
            String[] col={"image"};
            c=db.query("tableimage", col, null, null, null, null, null);

            if(c!=null){
                c.moveToFirst();
                do{
                    img=c.getBlob(c.getColumnIndex("image"));
                }while(c.moveToNext());
            }
            Bitmap b1=BitmapFactory.decodeByteArray(img, 0, img.length);
            //Bitmap b2=BitmapFactory.decodeFile(selectedImagePath);
            //setImage(b2);


            imageview.setImageBitmap(b1);
            Toast.makeText(this, "Retrive successfully", Toast.LENGTH_SHORT).show();
        }

    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {
                Uri selectedImageUri = data.getData();
                selectedImagePath = getPath(selectedImageUri);
                Bitmap b1=BitmapFactory.decodeFile(selectedImagePath);
                setImage(b1);

                System.out.println("Image Path : " + selectedImageUri);
                imageview.setVisibility(View.VISIBLE);
                imageview.setImageURI(selectedImageUri);
            }
        }
    }



    private void setImage(Bitmap image)
    {
        this.imageview.setImageBitmap(image);

    }

    @SuppressWarnings("deprecation")
    public String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        // Cursor cursor = managedQuery(uri, projection, null, null, null);
        Cursor c = getContentResolver().query(uri,projection,null,null,null);
        int column_index = c.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        c.moveToFirst();
        return c.getString(column_index);
    }

}
