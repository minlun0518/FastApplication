package com.tom.fastapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ConsumerActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumer);
        findViewById(R.id.pokerButton).setOnClickListener(this);
        findview();

    }

    private void findview() {
        //findViewById()
    }


    @Override
    public void onClick(View v) {
        Intent goPoker = new Intent(this, PokerActivity.class);
        startActivity(goPoker);
    }
}
