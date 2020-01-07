package com.tom.fastapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = GameActivity.class.getSimpleName();
    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        findView();
    }

    //針對四個都.setOnClickListener 以後好處理
    //直接this alt+enter
    public void findView() {
        findViewById(R.id.button_left).setOnClickListener(this);
        findViewById(R.id.button_right).setOnClickListener(this);
        findViewById(R.id.button_up).setOnClickListener(this);
        findViewById(R.id.button_down).setOnClickListener(this);
        gameView = findViewById(R.id.game);

    }

    @Override
    public void onClick(View view) {

        Log.d(TAG, "onClick");
        switch (view.getId()) {
            case R.id.button_up:
                Log.d("MainActivity", "onClick: UP");
                gameView.moveUp();
                break;
            case R.id.button_down:
                Log.d("MainActivity", "onClick: DOWN");
                gameView.moveDown();
                break;
            case R.id.button_left:
                Log.d("MainActivity", "onClick: LEFT");
                gameView.moveLeft();
                break;
            case R.id.button_right:
                Log.d("MainActivity", "onClick: RIGHT");
                gameView.moveRight();
                break;
        }
    }
}
