package com.example.android.klotski;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import java.util.List;

public class Level3 extends AppCompatActivity {
    private Klotski mKlotskiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_level3);

        List<Piece> blocks = BoardParser.parse("2,0,0,10,1,0,1,3,0,1,3,1,6,0,2,7,2,2,8,0,3,9,2,3,1,0,4,1,3,4");
        mKlotskiView = findViewById(R.id.klotski3);
        mKlotskiView.setlevel(3);
        mKlotskiView.setBlocks(blocks);
    }
    public void back(View view) {
        finish();
    }
}
