package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    // declaration of views
    private TextView tv;
    private Button change_Color;
    private String [] color = {"purple_200","teal_700"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initialize view
        tv = findViewById(R.id.text1);
        change_Color = findViewById(R.id.button1);

        // onClickListener to change the color of text view
        change_Color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random colorChange = new Random();
                String colorType = color[colorChange.nextInt(1)];
                int colorName = getResources().getIdentifier(colorType,"color",getApplicationContext().getPackageName());
                int Resource = ContextCompat.getColor(getApplicationContext() ,colorName);
                tv.setTextColor(Resource);

            }
        });


    }
}