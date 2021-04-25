package com.example.todo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public static final String EXTRA_REPLY = "com.example.todo5";

    private TextView mTextViewHeaderReply;
    private TextView mTextViewReply;
    private EditText rEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTextViewHeaderReply = (TextView) findViewById(R.id.textView2);
        mTextViewReply = (TextView) findViewById(R.id.textView3);
        rEditText = (EditText) findViewById(R.id.editText2);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        mTextViewReply.setText(message);
    }

    public void previousActivity(View view) {
        String message = rEditText.getText().toString();
        Intent returnIntent = new Intent();
        returnIntent.putExtra(EXTRA_REPLY,message);
        setResult(RESULT_OK,returnIntent);
        finish();
    }
}