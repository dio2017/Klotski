package com.example.android.klotski;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {
    public static String levels[] = {"0","0","0"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                , WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        final TextView startGame = findViewById(R.id.txt_startgame);

        startGame.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startGame.setTextColor(getResources().getColor(R.color.colorGrey));
                        break;
                    case MotionEvent.ACTION_UP:
                        startGame.setTextColor(getResources().getColor(R.color.white));
                        break;
                }
                return false;
            }
        });
    }

    public void chooselevel(View view) {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, ChooseLevelActivity.class);
        startActivity(intent);
    }
}
