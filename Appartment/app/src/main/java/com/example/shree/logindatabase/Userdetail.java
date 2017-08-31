package com.example.shree.logindatabase;

import android.app .Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by shree on 14/8/17.
 */

public class Userdetail extends AppCompatActivity implements View.OnClickListener
{

    EditText view;
    ListView listView;
    SQLiteDatabase db;
    Cursor c;
    Userdetail userdetail;
    MainActivity mainActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_activity);

        view = (EditText) findViewById(R.id.search);
        listView=(ListView)findViewById(R.id.ListView);

        view.setOnClickListener(this);

    }


    @Override
    public void onClick(View searchbutton)
    {
        if (searchbutton == view)
        {
           String name= (String) view.getText().toString();

            //  String name= (String) searchView.getQuery();//t1.getText().toString();

            c = db.rawQuery("SELECT * FROM userinfo3 WHERE Name LIKE '%"+ mainActivity.uname.getText() + "%'",null);

            // c = db.rawQuery("SELECT * FROM Names WHERE name LIKE '%"+name+"%' ",null);//WHERE Name LIKE '%"+t1.getText().toString()+"%'",null);

            int count = c.getCount();
            String values[] = new String[count+1];
            int i = 0;

            while(c.moveToNext())
            {
                values[i]= c.getString(c.getColumnIndex("username"));
                i++;
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(),
                    android.R.layout.activity_list_item, android.R.id.text1,values);

            listView.setAdapter(adapter);
        }

    }
}