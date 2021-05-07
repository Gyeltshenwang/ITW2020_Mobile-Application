package com.example.todo14ii;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private Button btn,date;
private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn= findViewById(R.id.button);
        date = findViewById(R.id.button2);
        tv = findViewById(R.id.textView2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("hello!");
                alert.setMessage("how are you");
                alert.setPositiveButton("fine", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "that sound good", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("notfine", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "that sound weired", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNeutralButton("normal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "that means you are neutral", Toast.LENGTH_SHORT).show();
                    }
                });alert.show();




            }
        });
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DialogFragment fra = new datePickerFragment();
                fra.show(getSupportFragmentManager(),"hello");

            }
        });


    }
    public void picker(int year,int day,int month){
        String Month = Integer.toString(month+1);
        String Year = Integer.toString(year);
        String Day = Integer.toString(day);
        String Date_message = (Month+"/"+day+"/"+year);
        Toast.makeText(this, "Date: "+Date_message, Toast.LENGTH_SHORT).show();
        tv.setText(Date_message);



    }


}