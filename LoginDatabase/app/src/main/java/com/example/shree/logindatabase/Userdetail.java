package com.example.shree.logindatabase;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

/**
 * Created by shree on 14/8/17.
 */

public class Userdetail extends AppCompatActivity
{
    SQLiteDatabase db;
    SearchView view;
    TextView data;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);

        view = (SearchView)findViewById(R.id.search);

        data = (TextView)findViewById(R.id.data);

        Cursor cur = db.query("username",null, null, null, null, null, null);
        cur.moveToFirst();

        while (cur.isAfterLast() == false)
        {
            data.append("n" + cur.getString(1));
            cur.moveToNext();
        }
        cur.close();


    }


}