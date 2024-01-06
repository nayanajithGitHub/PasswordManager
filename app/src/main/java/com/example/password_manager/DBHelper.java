package com.example.password_manager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;

    private static final String DB_NAME = "passwordDetails.db"; //database name
    private static final int DB_VERSION = 1; //version

    private static final String TABLE_NAME = "passwords"; //creating table parts
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_TITLE = "addtitle";
    private static final String COLUMN_USERNAME = "adduname";
    private static final String COLUMN_PASSWORD = "addpassword";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION); //up things called here
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = " CREATE TABLE " + TABLE_NAME + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_TITLE + " TEXT ," +
                COLUMN_USERNAME + " TEXT ," +
                COLUMN_PASSWORD + " TEXT)"; //like we create a table on sql create table here

        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    //CRUD
    /*
        C - CREATE/ADD
        R - READ
        U - UPDATE
        D - DELETE
        S - SEARCHING
     */
    public void addPasswords(String addtitle, String adduname, String addpassword) {
        //1.Need to write permission
        SQLiteDatabase db = this.getWritableDatabase();

        //2.ContentValue - Store like array
        ContentValues cv = new ContentValues();

        //3.Insert columns in to cv
        cv.put(COLUMN_TITLE, addtitle);
        cv.put(COLUMN_USERNAME, adduname);
        cv.put(COLUMN_PASSWORD, addpassword);

        //insert table into database
        long result = db.insert(TABLE_NAME, null, cv);

        if (result == -1) { //-1 means inserting error
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Succeed", Toast.LENGTH_SHORT).show();
        }

    }

    Cursor selectAllRecords() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME;
        Cursor cursor = null;

        if (db != null) {
            cursor = db.rawQuery(query, null);
        } else {
            Toast.makeText(context, "Empty", Toast.LENGTH_SHORT).show();
        }
        return cursor;
    }
    void updateData(String id,String title, String uname,String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues convalue= new ContentValues();

        convalue.put(COLUMN_TITLE, title);
        convalue.put(COLUMN_USERNAME, uname);
        convalue.put(COLUMN_PASSWORD, password);

        long result = db.update(TABLE_NAME,convalue,"id=?",new String[]{id});

        if(result ==-1){
            Toast.makeText(context,"Update Failed ",Toast.LENGTH_LONG).show();

        }else {
            Toast.makeText(context,"Successfully Updated",Toast.LENGTH_SHORT).show();
        }
    }
    void deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "id=?", new String[]{id});

        if (result == -1) {
            Toast.makeText(context, "Delete Failed", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(context, "Successfully Deleted", Toast.LENGTH_SHORT).show();
        }
    }




}
