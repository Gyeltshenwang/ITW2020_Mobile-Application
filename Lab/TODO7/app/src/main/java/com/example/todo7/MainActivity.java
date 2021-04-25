package com.example.todo7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView mText;
private EditText mEdit;
private Button btn;
private int counter =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mText = findViewById(R.id.tV);
        mEdit = findViewById(R.id.eT);
        btn = findViewById(R.id.button);
       if(savedInstanceState != null){
           counter= savedInstanceState.getInt("count");
           mEdit.setText(String.valueOf(counter));
           mEdit.setText(Integer.toString(counter));

       }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;

                mEdit.setText(String.valueOf(counter));
                mText.setText(Integer.toString(counter));

            }
        });



    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count",counter);

    }
}