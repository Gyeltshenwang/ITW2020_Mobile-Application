package com.example.image;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private TextView tv;
   private RadioButton sameDay,nextDay,pickUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = findViewById(R.id.message);
        sameDay = findViewById(R.id.radioButton);
        nextDay = findViewById(R.id.radioButton2);
        pickUp = findViewById(R.id.radioButton3);



        // get extra
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA);
        tv.setText(message);

       // spinner.setOnItemClickListener(this,);x
        Spinner spinner = findViewById(R.id.spinner);
        if (spinner!=null){
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.label_array,android.R.layout.simple_spinner_item);
        if(spinner!=null){
            spinner.setOnItemSelectedListener(this);
            spinner.setAdapter(adapter);
        }


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
String message = parent.getItemAtPosition(position).toString();
displayToast(message);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void orderItem(View view){
        boolean itemSelected = ((RadioButton)view).isChecked();
        switch(view.getId()){
            case R.id.radioButton:
            displayToast("same day messanger services");
            break;
            case R.id.radioButton2:
            displayToast("same day ground services");
            break;
            case R.id.radioButton3:
            displayToast("pickup");
            default:
                break;
        }
    }
    public void displayToast(String pick_up){
        Toast.makeText(getApplicationContext(),pick_up, Toast.LENGTH_LONG).show();
    }
}
