package com.example.tabby.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;


import com.example.tabby.activities.MainActivity;
import com.example.tabby.fragments.FormFragment;
import com.example.tabby.fragments.ListFragment;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private ArrayList<Fragment> listFragments = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }


    public Fragment createFragment(int position) {
        Fragment fragment = new Fragment();
        switch (position){
            case 0:
                fragment = new FormFragment();
                break;
            case 1:
                fragment = new ListFragment();
                break;
        }

        return fragment;
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public void addFragment(Fragment fragment){
        listFragments.add(fragment);
    }
}
