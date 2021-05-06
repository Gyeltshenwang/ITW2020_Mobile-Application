package com.example.image;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA ="mainActivity" ;
    //extra
    String list;

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
       Toolbar mtoolbar =  findViewById(R.id.toolbar);
       setSupportActionBar(mtoolbar);
        // support toolbar



        //getSupportActionBar().hide();// hide a toolbar

      // onClicking the images it perform the action;
        Apple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_Apple.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "This is an Apple", Toast.LENGTH_SHORT).show();

                String Apple = "you have ordered an Apple";
                list  = Apple;
            }
        });

        Lemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text_Lemon.setVisibility(View.VISIBLE);
                Toast.makeText(MainActivity.this, "This is Lemon", Toast.LENGTH_SHORT).show();
                String lemon = " you have ordered lemon";
                list = lemon;

            }
        });

        starFruit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                text_star.setVisibility(View.VISIBLE);
                String star = " you have ordered star fruit";
                 list = star;
              Toast.makeText(MainActivity.this, "This is star Fruits", Toast.LENGTH_SHORT).show();
            }
        });
        Call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent intent = new Intent(MainActivity.this,MainActivity2.class);
             intent.putExtra(EXTRA,list);
             startActivity(intent);
            }
        });
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.gallery:
                displayToast("Invalid  number");
            return  true;
            case R.id.password:
                Intent itent = new Intent(this,MainActivity2.class);
                itent.putExtra(EXTRA,list);
                startActivity(itent);
            return true;
            case R.id.phone:
                displayToast("Invalid phone number");
                return true;
            case R.id.email:
                displayToast("invalid email");
                return true;


        }
        return true;
    }


public void displayToast(String pick_up){
    Toast.makeText(getApplicationContext(),pick_up, Toast.LENGTH_LONG).show();
}
}