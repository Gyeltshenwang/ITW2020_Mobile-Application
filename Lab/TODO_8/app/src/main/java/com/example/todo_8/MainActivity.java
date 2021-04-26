package com.example.todo_8;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText website,location,share;
    private Button btn_web,btn_location,btn_share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        website = findViewById(R.id.website);
        location = findViewById(R.id.location);
        share = findViewById(R.id.shear);
        btn_web = findViewById(R.id.btn_website);
        btn_location = findViewById(R.id.btn_Location);
        btn_share = findViewById(R.id.btn_share);
        //website
        btn_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = website.getText().toString();
                Uri uri = Uri.parse(txt);
                Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                if(intent.resolveActivity(getPackageManager())!=null){
                    startActivity(intent);

                }
               else{
                    Toast.makeText(MainActivity.this, "sorry", Toast.LENGTH_SHORT).show();
                }


            }
        });



        //share

    }

    public void share(View view) {
        String msg = share.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder.from(this)
                .setType(mimeType)
                .setChooserTitle("share")
                .setText(msg)
                .startChooser();
    }

    public void Location(View view) {
        String locatation = location.getText().toString();
        Uri uri = Uri.parse("geo:0,0?q="+locatation);
        Intent locatation_intent = new Intent(Intent.ACTION_VIEW,uri);
        if(locatation_intent.resolveActivity(getPackageManager())!=null){
            startActivity(locatation_intent);
        }
    }
}