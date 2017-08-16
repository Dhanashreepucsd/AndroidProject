package com.example.shree.logindatabase;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnTouchListener,View.OnClickListener
{
    Button login;
    TextView create,forgot;
    EditText uname,pass;


    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button)findViewById(R.id.BLogin);
        create = (TextView) findViewById(R.id.Tcreate);
        forgot =(TextView) findViewById(R.id.Tforgot);
        uname = (EditText) findViewById(R.id.Tuname);
        pass = (EditText) findViewById(R.id.ETpass);

        login.setOnClickListener(this);
        create.setOnTouchListener(this);



        //OPEN OR CREATE DATABASE

        db = openOrCreateDatabase("DataUser.db", Context.MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS userinfo2(username varchar primary key,password varchar);");




    }

    @Override
    public void onClick(View view)
    {
        if(view == login)
        {
            db.execSQL("INSERT INTO userinfo2 VALUES('" + uname.getText() + "','" + pass.getText() + "');");
            Toast.makeText(MainActivity.this, "Record inserted successfully", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(MainActivity.this,Userdetail.class);
            startActivity(intent);

        }
        else
        {
            Toast.makeText(MainActivity.this, "can not login" , Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent)
    {

        if(view==create)
        {

            Intent intentSignup = new Intent(MainActivity.this, Create_account.class);
            startActivity(intentSignup);
        }
        else
            Toast.makeText(MainActivity.this, "can not create page" , Toast.LENGTH_LONG).show();
        return false;
    }


}
