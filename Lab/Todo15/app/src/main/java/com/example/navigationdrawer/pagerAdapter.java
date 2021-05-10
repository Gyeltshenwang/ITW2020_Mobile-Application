package com.example.navigationdrawer;

import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pagerAdapter extends FragmentPagerAdapter {
    int mNumOfTab;

    public pagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.mNumOfTab = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return new TabFragment();
            case 1: return  new Tb2Fragment();
            case 2: return  new Tab3Fragment();

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return mNumOfTab;
    }
}
