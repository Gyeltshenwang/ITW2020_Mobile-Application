package com.example.todo_18;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ArrayList<Sport> msport;
    private SportsAdapter mAdapter;
    private ImageView mSportsImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //initialize the recycle view
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mSportsImageView = findViewById(R.id.sportsImage);

        //initialize the arratlist that will contain the data
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initialize the adapter and set it at the recycleview
        msport = new ArrayList<>();

        mAdapter = new SportsAdapter(this, msport);
        mRecyclerView.setAdapter(mAdapter);

    initializeData();
}


    private void initializeData(){
        //get the resource the XMl file
        TypedArray sportsImageResources = getResources().obtainTypedArray(R.array.Sports_images);
        String[] sportList = getResources().getStringArray(R.array.Sports_Title);
        String[] sportInfo = getResources().getStringArray(R.array.Sports_Info);

        //clear the existing data (to avoid duplication)
        msport.clear();

        //create the arraylist of sports objects with the titles and information about each sports
        for (int i=0;i<sportList.length;i++){
            msport.add(new Sport(sportList[i],sportInfo[i], sportsImageResources.getResourceId(i, 0)));
        }
        //notify the change
        mAdapter.notifyDataSetChanged();
        sportsImageResources.recycle();

    }



}


