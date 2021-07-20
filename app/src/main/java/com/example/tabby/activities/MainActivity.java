package com.example.tabby.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;


import com.example.tabby.R;
import com.example.tabby.adapters.ViewPagerAdapter;
import com.example.tabby.fragments.FormFragment;
import com.example.tabby.fragments.ListFragment;
import com.example.tabby.interfaces.CreatePerson;
import com.example.tabby.models.Country;
import com.example.tabby.models.Person;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity implements CreatePerson {
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    public static final int LISTFRAGMENT = 1;
    public static final int FORMFRAGMENT = 0;
    private ViewPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        connectUI();
        setSupportActionBar(toolbar);

        tabLayout.addTab(tabLayout.newTab().setText("Form"));
        tabLayout.addTab(tabLayout.newTab().setText("List"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());

        viewPager2.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                viewPager2.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private void connectUI(){
        toolbar = findViewById(R.id.toolbar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager);
    }

    @Override
    public void createPerson(Person person) {
        ListFragment fragment = (ListFragment) getSupportFragmentManager().getFragments().get(LISTFRAGMENT);
        fragment.addPerson(person);
        viewPager2.setCurrentItem(LISTFRAGMENT);
    }
}