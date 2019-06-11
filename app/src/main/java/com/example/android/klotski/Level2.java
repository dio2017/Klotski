package com.example.android.klotski;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class Level2 extends AppCompatActivity {
    private Klotski mKlotskiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_level2);

        List<Piece> blocks = BoardParser.parse("2,0,0,10,1,0,3,3,0,1,0,2,6,1,2,1,3,2,1,0,3,7,1,3,1,3,3,8,1,4");
        mKlotskiView = findViewById(R.id.klotski2);
        mKlotskiView.setlevel(2);
        mKlotskiView.setBlocks(blocks);
    }
    public void back(View view) {
        finish();
    }

    // 重写onDestroy(), 可以保证活动销毁之前一定会调用这个方法.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        String levelState = MainActivity.levels[0] + MainActivity.levels[1] + MainActivity.levels[2];
        save(levelState);
    }

    public void save (String inputText){
        FileOutputStream out = null;
        BufferedWriter writer = null;

        try {
            out = openFileOutput("KlotskiData", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(inputText);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer!= null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
