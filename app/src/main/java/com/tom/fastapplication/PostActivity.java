package com.tom.fastapplication;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tom.fastapplication.ui.main.PageViewModel;
import com.tom.fastapplication.ui.main.SectionsPagerAdapter;

public class PostActivity extends AppCompatActivity {

    private PageViewModel pageViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        final ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        //tabs.setupWithViewPager(viewPager);
        tabs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int input= getExtraData(pageViewModel,mIndex);
                //showView(input);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }

    public void showView(int input) {
        Intent goBasic = new Intent(this, BasicActivity.class);
        Intent goRequest = new Intent(this, RequestActivity.class);
        Intent goMap = new Intent(this, MapActivity.class);

        switch (input) {
            case 1:
                startActivity(goBasic);
                break;
            case 2:
                startActivity(goRequest);
                break;
            case 3:
                startActivity(goMap);
                break;
        }
    }
}