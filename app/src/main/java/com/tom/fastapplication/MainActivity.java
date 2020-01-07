package com.tom.fastapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_LOGIN=21;//全大寫是特別的貓逆，不會變，用來表示特別的東西
    boolean logon =false; //是不是登入
    private LoginActivity loginactivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!logon) {
            //如果不是登入狀態就呼叫login intent
            Intent login = new Intent(this, LoginActivity.class);
            startActivityForResult(login, REQUEST_CODE_LOGIN);
        }
    }

    public void findViews() {

        findViewById(R.id.goConsumerButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consumer =new Intent(MainActivity.this,ConsumerActivity.class);
                startActivity(consumer);
            }
        });

        findViewById(R.id.goWorkButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent worker =new Intent(MainActivity.this,WorkActivity.class);
                startActivity(worker);
            }
        });



    }

    @Override
    //防止按返回
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //requestCode:出門前貼標籤
        //resultCode:回來帶的結果
        if(requestCode == REQUEST_CODE_LOGIN){
            //判斷是不是正常回家，如果有好好的來回
            if(resultCode != RESULT_OK){
                Toast.makeText(this,"再見",Toast.LENGTH_LONG).show();
                finish();
            }else {
                logon=true;
                findViews();
            }
        }
       // super.onActivityResult(requestCode, resultCode, data);
    }

}
