package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.tabs.TabLayout;
public class MainActivity extends AppCompatActivity {

    private TabLayout tb;
    private Toolbar tbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tb= findViewById(R.id.tab);
        tb.addTab(tb. newTab().setText(R.string.app_name));
        tb.addTab(tb. newTab().setText(R.string.hello_world));
        tb.addTab(tb. newTab().setText(R.string.hello_blank_fragment));
        tbar = findViewById(R.id.tool);
        setSupportActionBar(tbar);

        tb.setTabGravity(TabLayout.GRAVITY_FILL);
        ViewPager viewpager = findViewById(R.id.viewpager);

        pagerAdapter page = new pagerAdapter(getSupportFragmentManager(), tb.getTabCount());


        viewpager.setAdapter(page);
        viewpager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tb));
        tb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }
}