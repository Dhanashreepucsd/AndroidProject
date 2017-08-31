package com.example.shree.logindatabase;

import android.content.ContentProviderOperation;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shree on 22/8/17.
 */


public class DBHelper extends SQLiteOpenHelper

{
    public static final String KEY_USER = "USER";
    public static final String KEY_PASS = "PASS";

    private static final String DATABASE_NAME = "Database.db";
    private static final String DATABASE_TABLE = "userTable";
    private static final int DATABASE_VERSION = 1;

    private static DBHelper ourHelper;
    private static SQLiteDatabase db;
    private static Context ourContext;
    Userdetail userdetail;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE " + DATABASE_TABLE + " (" +
                KEY_USER + " VARCHAR PRIMARY KEY TEXT NOT NULL UNIQUE, " +
                KEY_PASS + " TEXT NOT NULL UNIQUE);");

        db.execSQL("INSERT INTO" + getDatabaseTable() + " VALUES('" + KEY_USER + "','" + KEY_PASS + "');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + getDatabaseTable());
        onCreate(db);
    }
    public boolean addUser(String name, String pass)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_USER,name);
        contentValues.put(KEY_PASS, pass);

        db.insert(DATABASE_TABLE, null, contentValues);
        db.close();
        return true;
    }

    public static String getDatabaseTable()

    {
        return DATABASE_TABLE;
    }

   /* public List<String> getrecords() {
        List<String> arraylist = new ArrayList<String>();

        String[] columns = new String[]{KEY_USER};
        Cursor c = ourDatabase.query(DATABASE_TABLE, columns, null, null, null, null, null);
        String result = "";
        int iName = c.getColumnIndex(KEY_USER);


        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext())
        {
            arraylist.add(c.getString(iName));

            return arraylist;

        }

        return arraylist;
    }*/

}
