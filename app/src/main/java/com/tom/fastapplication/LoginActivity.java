package com.tom.fastapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //login 方法名稱可以全小寫
    public void login(View view){
        EditText edUsername = findViewById(R.id.username);
        EditText edPassword = findViewById(R.id.password);
        String username = edUsername.getText().toString();
        String password = edPassword.getText().toString();

        if("rd7791".equals(username)&&"12345678".equals(password)){
            setResult(RESULT_OK);
            SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
            pref.edit()
                    .putString("loginEdUsername",username)
                    .apply();
            Log.d(TAG,"loginEdUsername"+edUsername);

            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.rdteacher)
                    .setTitle("登入成功")
                    .setMessage("歡迎最帥的孟賢老師~新年快樂")
                    .setPositiveButton("呵呵", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();
                        }
                    })
                    .show();
        }
        else {
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.bad)
                    .setTitle("登入訊息")
                    .setMessage("登入失敗")
                    .setPositiveButton("OK",null)
                    .show();
        }
    }
}
