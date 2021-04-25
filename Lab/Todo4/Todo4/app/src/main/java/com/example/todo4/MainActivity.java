package com.example.todo4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_message = "com.example.todo_4";
    private EditText send_Message;

    public static final int TEXT_REQUEST = 1;
    private TextView reply_header;
    private TextView reply_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send_Message = findViewById(R.id.eText);
        reply_header =findViewById(R.id.text1);
        reply_message = findViewById(R.id.text);
    }
    public void send(View v) {
        Intent obj = new Intent(this,Activity2.class);
        String mssg = send_Message.getText().toString();
        obj.putExtra(EXTRA_message, mssg);
        startActivityForResult(obj, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String final_mssg = data.getStringExtra(Activity2.EXTRA_replyMessage);
                reply_header.setVisibility(View.VISIBLE);
                reply_message.setText(final_mssg);
                reply_message.setVisibility(View.VISIBLE);
            }
        }
    }



}