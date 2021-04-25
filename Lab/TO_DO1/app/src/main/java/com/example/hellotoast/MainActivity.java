package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private int mCounter = 0; // initially decleared as 0:b
    Button but;
    Button but1;
    TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initalize
        but = (Button)findViewById(R.id.btn);
        but1 = (Button)findViewById(R.id.btn1);
        txt = (TextView)findViewById(R.id.textView);
        //
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCounter++;
                txt.setText(Integer.toString(mCounter));
            }
        });
    }
    //   this function will show the toast messages;
    public void toast(View view){
        Toast.makeText(this, "HELLO TOAST!!", Toast.LENGTH_SHORT).show();

    }


}