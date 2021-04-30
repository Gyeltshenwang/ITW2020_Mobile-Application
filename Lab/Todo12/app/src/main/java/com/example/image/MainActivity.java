package com.example.image;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    // declaration of views
    private ImageView Apple,Lemon,starFruit;
    private FloatingActionButton Call;
    private TextView text_Apple,text_Lemon,text_star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // initialize the view
        setContentView(R.layout.activity_main);
        Apple = findViewById(R.id.imageApple);
        Lemon = findViewById(R.id.imageLemon);
        starFruit = findViewById(R.id.image_star);
        Call = findViewById(R.id.call);
        text_Apple = findViewById(R.id.textView2);
        text_Lemon = findViewById(R.id.textView3);
        text_star = findViewById(R.id.textView4);

        getSupportActionBar().hide();// hide a toolbar

      // onClicking the images it perform the action;
        Apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_Apple.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "This is an Apple", Toast.LENGTH_SHORT).show();
            }
        });

        Lemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_Lemon.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "This is Lemon", Toast.LENGTH_SHORT).show();

            }
        });

        starFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text_star.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "This is star Fruits", Toast.LENGTH_SHORT).show();
            }
        });
        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:17339523"));
                startActivity(in);
            }
        });
    }
}