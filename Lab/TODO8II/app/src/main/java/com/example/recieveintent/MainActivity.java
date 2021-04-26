package com.example.recieveintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView mText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = findViewById(R.id.text);

        Intent intent= getIntent();
        Uri uri = intent.getData();
        if (uri!=null){
            String msg = uri.toString();
            mText.setText(msg);
        }
    }
}