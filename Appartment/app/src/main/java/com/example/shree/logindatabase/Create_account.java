package com.example.shree.logindatabase;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by shree on 8/8/17.
 */

public class Create_account extends AppCompatActivity implements View.OnClickListener
{
    SQLiteDatabase db;

    Button createadd;
    EditText apartment,addres,country,city,pin,totalflat,block;
    @Override
    protected void onCreate(Bundle saveInstanState)
    {
        super.onCreate(saveInstanState);
        setContentView(R.layout.create_account_page);

        createadd = (Button)findViewById(R.id.CreateAdda);

        apartment = (EditText)findViewById(R.id.appartment);
        addres = (EditText)findViewById(R.id.address);
        country = (EditText)findViewById(R.id.country);
        city= (EditText)findViewById(R.id.city);
        pin = (EditText)findViewById(R.id.pin);
        totalflat = (EditText)findViewById(R.id.totalflats);
        block = (EditText)findViewById(R.id.Block);



        db = openOrCreateDatabase("Appartment.db", Context.MODE_PRIVATE, null);

        db.execSQL("CREATE TABLE IF NOT EXISTS USERDETAILS(APPRTMENT TEXT NOT NULL UNIQUE ,ADDRESS varchar,COUNTRY TEXT NOT NULL,CITY TEXT NOT NULL,PIN NUMBER,TOTALFLAT NUMBER,BLOCK varchar);");

        createadd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(view == createadd)
        {
            db.execSQL("INSERT INTO USERDETAILS VALUES('" + apartment.getText() + "','" + addres.getText() + "','" + country.getText() +  "','" +city.getText()+ "','" + pin.getText()  + "','" + totalflat.getText()+ "','" + block.getText()+  "');");

            Toast.makeText(Create_account.this, "Adda inserted successfully", Toast.LENGTH_LONG).show();

            Intent intent = new Intent(Create_account.this,Personaldetails.class);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(Create_account.this, "can not inserted" , Toast.LENGTH_LONG).show();
        }


    }
}
