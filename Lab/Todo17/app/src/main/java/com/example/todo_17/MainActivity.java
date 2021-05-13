package com.example.todo_17;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int score1, score2;
    private TextView mscoretext1, mscoretext2;
    //private Button ViewID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mscoretext1 = (TextView) findViewById(R.id.score1);
        mscoretext2 = (TextView) findViewById(R.id.score2);
        //ViewID = findViewById(R.id.decreaseTeam1);




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void increase(View view) {
        int viewID = view.getId();
        switch (viewID){
            //If it was on team 1

            case R.id.IncreaseTeam1:

                score1++;
                mscoretext1.setText(String.valueOf(score1));
                break;

            case R.id.IncreaseTeam2:
                score2++;
                mscoretext2.setText(String.valueOf(score2));

        }

    }

    public void decrease(View view) {
        int viewID = view.getId();
        switch (viewID){
            //If it was on team 1

            case R.id.decreaseTeam1:
            score1--;
            mscoretext1.setText(String.valueOf(score1));
            break;

            case R.id.decreaseTeam2:
            score2--;
            mscoretext2.setText(String.valueOf(score2));

        }

    }
}