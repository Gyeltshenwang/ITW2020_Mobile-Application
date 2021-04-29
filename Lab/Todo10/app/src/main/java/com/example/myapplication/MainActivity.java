package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mEdit1,mEdit2;
    private Button btn_sub,btn_add,btn_multi,btn_div;
    private TextView mResult;
    private Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdit1 = findViewById(R.id.edt_mText);
        mEdit2 = findViewById(R.id.edt_mText1);
        btn_add = findViewById(R.id.btn_add);
        btn_sub = findViewById(R.id.btn_sub);
        btn_multi = findViewById(R.id.btn_multi);
        btn_div = findViewById(R.id.btn_div);
        mResult = findViewById(R.id.tex_view);

        //Creating object
        calculator = new Calculator();
        // Addition
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = mEdit1.getText().toString();
                String num2 = mEdit2.getText().toString();
                double Result = calculator.add(Double.valueOf(num1),Double.valueOf(num2));
                mResult.setText(String.valueOf(Result));


            }
        });

        //Subtraction
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = mEdit1.getText().toString();
                String num2 = mEdit2.getText().toString();
                double Result = calculator.sub(Double.valueOf(num1),Double.valueOf(num2));
                mResult.setText(String.valueOf(Result));

            }
        });

        //Multiply
        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = mEdit1.getText().toString();
                String num2 = mEdit2.getText().toString();
                double Result = calculator.multi(Double.valueOf(num1),Double.valueOf(num2));
                mResult.setText(String.valueOf(Result));

            }
        });
        // Division
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num1 = mEdit1.getText().toString();
                String num2 = mEdit2.getText().toString();
                double Result = calculator.div(Double.valueOf(num1),Double.valueOf(num2));
                mResult.setText(String.valueOf(Result));

            }
        });

    }
}