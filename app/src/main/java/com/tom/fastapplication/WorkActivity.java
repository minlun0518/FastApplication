package com.tom.fastapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WorkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_work);

        findViews();

    }

    private void findViews() {

        findViewById(R.id.goWorkButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goWork = new Intent(WorkActivity.this,OrderActivity.class);
                startActivity(goWork);
            }
        });

        findViewById(R.id.gamebutton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent game = new Intent(WorkActivity.this,GameActivity.class);
                startActivity(game);
            }
        });


        findViewById(R.id.questionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent question = new Intent(WorkActivity.this,QuestionActivity.class);
                startActivity(question);
            }
        });

        findViewById(R.id.leaveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(WorkActivity.this)
                        .setIcon(R.drawable.car)
                        .setTitle("什麼")
                        .setMessage("你確定要離開嗎")
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        })
                        .show();
            }
        });
    }

}
