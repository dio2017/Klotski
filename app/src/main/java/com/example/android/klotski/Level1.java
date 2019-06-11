package com.example.android.klotski;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import org.xml.sax.Parser;

import java.util.List;


public class Level1 extends AppCompatActivity {
    private Klotski mKlotskiView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_level1);

        List<Piece> blocks = BoardParser.parse("2,0,0,10,1,0,3,3,0,4,0,2,6,1,2,5,3,2,1,1,3,1,2,3,1,0,4,1,3,4");
        mKlotskiView = (Klotski) findViewById(R.id.klotski1);
        mKlotskiView.setlevel(1);
        mKlotskiView.setBlocks(blocks);
    }

    public void back(View view) {
        finish();
    }

}
