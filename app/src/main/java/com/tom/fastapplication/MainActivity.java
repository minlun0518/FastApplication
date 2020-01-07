package com.tom.fastapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_LOGIN=21;//全大寫是特別的貓逆，不會變，用來表示特別的東西
    boolean logon =false; //是不是登入
    private LoginActivity loginactivity;
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int REQUEST_CODE_NICKNAME=21;
    private TextView name;
    private TextView age;
    private TextView gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.nameTextView);
        age = findViewById(R.id.ageTextView);
        gender = findViewById(R.id.genderTextView);

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

        //setValue()
        Log.d(TAG,"setValue");
            String usename = getSharedPreferences("login", MODE_PRIVATE)
                    .getString("loginEdUsername", "");
            name.setText(usename+"");
            Log.d(TAG,usename+"");
            /*
            String userage = getSharedPreferences("AGE", MODE_PRIVATE)
                    .getString("edAge", "");
            age.setText(userage+"");
            Log.d(TAG,age+"");
            String usergender = getSharedPreferences("GENDER", MODE_PRIVATE)
                    .getString("edGender", "");
            gender.setText(usergender+"");
            Log.d(TAG,gender+"");
            */

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
    }
}
