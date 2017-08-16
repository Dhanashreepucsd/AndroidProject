package com.example.shree.buttonclickapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnclk;
    Button btnreset;
    TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnclk = (Button)findViewById(R.id.Click);
        btnreset = (Button)findViewById(R.id.Reset);

        txt = (TextView)findViewById(R.id.textViewCount);

        btnclk.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String countVal = txt.getText().toString();
            int intcntval = Integer.parseInt(countVal);
            intcntval++;

            txt.setText(String.valueOf(intcntval));

            }
        });
        btnreset.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                txt.setText(String.valueOf(0));

            }
        });
    }
}
