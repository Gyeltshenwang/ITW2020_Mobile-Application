package edu.bt.todo16;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.LinkedList;
public class MainActivity extends AppCompatActivity {
    private final LinkedList<String > mWordList = new LinkedList<>();
    private RecyclerView recycle;
    private ListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i =0; i < 20; i++){
            mWordList.addLast("Word" +i);
        }

        recycle= findViewById(R.id.recycle);

        mAdapter = new ListAdapter(this,mWordList);
        recycle.setAdapter(mAdapter);
        recycle.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wordListSize = mWordList.size();
                mWordList.addLast("+ Word " + wordListSize);
                recycle.getAdapter().notifyItemInserted(wordListSize);
                recycle.smoothScrollToPosition(wordListSize);

            }
        });

    }
}