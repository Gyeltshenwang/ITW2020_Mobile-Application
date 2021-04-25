package com.example.todo5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE = "com.example.todo5";

    public static final int TEXT_REQUEST = 1;

    private TextView mTextViewHeader;
    private TextView mTextViewReply;
    private EditText mEditText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewHeader = (TextView) findViewById(R.id.textView);
        mTextViewReply = (TextView) findViewById(R.id.textView1);
        mEditText = (EditText) findViewById(R.id.editText1);
        Log.d(LOG_TAG,"onCreate");

        if(savedInstanceState != null){
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            if(isVisible){
                mTextViewHeader.setVisibility(View.VISIBLE);
                mTextViewReply.setText(savedInstanceState.getString("reply_Text"));
                mTextViewReply.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG,"onStart");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(LOG_TAG,"onResume");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG,"onPause");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG,"onStop");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(LOG_TAG,"onDestroy");
    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this,MainActivity2.class);
        String message = mEditText.getText().toString();
        mTextViewHeader.setVisibility(View.VISIBLE);
        intent.putExtra(EXTRA_MESSAGE,message);
        startActivityForResult(intent,TEXT_REQUEST);
        mTextViewReply.setVisibility(View.VISIBLE);

    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == TEXT_REQUEST){
            if(resultCode == RESULT_OK){
                String reply = data.getStringExtra(MainActivity2.EXTRA_REPLY);
                mTextViewHeader.setVisibility(View.VISIBLE);
                mTextViewReply.setText(reply);
                mTextViewReply.setVisibility(View.VISIBLE);
            }
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // sva data for instance in the activity;
        if(mTextViewReply.getVisibility() == View.VISIBLE){
            outState.putBoolean("reply_visible",true);
            outState.putString("reply_Text",mTextViewReply.getText().toString());
        }
    }
}