package com.example.todo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {
    public static final String EXTRA_replyMessage = "com.example.todo_4Reply";
    private EditText reply_Message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        Intent obj = getIntent();
        String message = obj.getStringExtra(MainActivity.EXTRA_message);
        TextView txt = findViewById(R.id.text);
        txt.setText(message);
        reply_Message = findViewById(R.id.eText);

    }

    public void reply(View view) {
        Intent obj1 = new Intent();
        String mssg_reply = reply_Message.getText().toString();
        obj1.putExtra(EXTRA_replyMessage, mssg_reply);
        setResult(RESULT_OK, obj1);
        finish();
    }
}