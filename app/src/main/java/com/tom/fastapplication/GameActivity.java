package com.tom.fastapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class GameActivity extends AppCompatActivity implements View.OnClickListener /*implements View.OnClickListener */{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        findView();
    }

    public void findView() {
        findViewById(R.id.button_left).setOnClickListener(this);
        findViewById(R.id.button_right).setOnClickListener(this);
        findViewById(R.id.button_up).setOnClickListener(this);
        findViewById(R.id.button_down).setOnClickListener(this);
        //GameView gameView = findViewById(R.id.game);

    }

    @Override
    public void onClick(View v) {

        Log.d("MainActivity","onClick");
       /* switch (view.getId()){
            case R.id.button_up:
                Log.d("MainActivity","onClick.up");
                //gameView.setPosY(gameView.getY()-50);
                gameView.moveUp();
                gameView.invalidate();
                break;
            case R.id.button_down:
                Log.d("MainActivity","onClick.down");
                //gameView.setPosY(gameView.getY()+50);
                gameView.moveDown();
                gameView.invalidate();
                Log.d("MainActivity","posY="+gameView.getPosX());
                break;
            case R.id.button_left:
                Log.d("MainActivity","onClick.left");
                gameView.moveLeft();
                //gameView.setPosX(gameView.getX()-50);
                Log.d("MainActivity","posX="+gameView.getPosX());
                gameView.invalidate();
                break;
            case R.id.button_right:
                Log.d("MainActivity","onClick.right");
                //gameView.setPosX(gameView.getX()+50); ！不要寫在自己身上　找死
                gameView.moveRight();
                gameView.invalidate();
                Log.d("MainActivity","posX="+gameView.getPosX());
                break;

 */
        }


}
