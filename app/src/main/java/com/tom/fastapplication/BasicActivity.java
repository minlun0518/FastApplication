package com.tom.fastapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.tom.fastapplication.R;


public class BasicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
    }
}
