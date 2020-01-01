package com.tom.fastapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_LOGIN=21;//全大寫是特別的貓逆，不會變，用來表示特別的東西
    boolean logon =false; //是不是登入

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (!logon) {
            //如果不是登入狀態就呼叫login intent
            Intent login = new Intent(this, LoginActivity.class);
//            startActivity(login);
            //startActivityForResult(login, REQUEST_CODE_LOGIN);
            startActivityForResult(login,110);//
        }
    }

    @Override
    //防止按返回
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //requestCode:出門前貼標籤
        //resultCode:回來帶的結果
        if(requestCode == REQUEST_CODE_LOGIN){
            //判斷是不是正常回家，如果有好好的來回
            if(requestCode != REQUEST_CODE_LOGIN){
                Toast.makeText(MainActivity.this,"再見",Toast .LENGTH_LONG).show();
                finish();
            }else {
                logon=true;
            }
        }
       // super.onActivityResult(requestCode, resultCode, data);
    }




}
