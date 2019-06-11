package com.example.android.klotski;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class ChooseLevelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_choose_level);

        final TextView levelText1 = findViewById(R.id.level1text);
        TextView levelText2 = findViewById(R.id.level2text);
        TextView levelText3 = findViewById(R.id.level3text);

        setLevelTextColor(levelText1);
        setLevelTextColor(levelText2);
        setLevelTextColor(levelText3);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setLevelTextColor(final TextView levelText) {
        levelText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        levelText.setTextColor(getResources().getColor(R.color.white));
                        break;
                    case MotionEvent.ACTION_UP:
                        levelText.setTextColor(getResources().getColor(R.color.colorb));
                        break;
                }
                return false;
            }
        });
    }

    public void exit(View view) {
        finish();
    }

    public void goLevel1(View view) {
        Intent intent = new Intent();
        intent.setClass(ChooseLevelActivity.this, Level1.class);
        startActivity(intent);
    }

    public void goLevel2(View view) {
        Intent intent = new Intent();
        intent.setClass(ChooseLevelActivity.this, Level2.class);
        startActivity(intent);
    }

    public void goLevel3(View view) {
        Intent intent = new Intent();
        intent.setClass(ChooseLevelActivity.this, Level3.class);
        startActivity(intent);
    }
}
