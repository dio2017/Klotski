package com.example.android.klotski;

import android.content.Context;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class CollectionActivity extends AppCompatActivity {
    private ImageView myImg;
    private TextView myTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN
                , WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_collection);

        myTxt = findViewById(R.id.textView);
        myImg = findViewById(R.id.imageView);
        setMyImg();
    }

    public void exit(View view) {
        finish();
    }

    public void setMyImg() {
        String inputText = load();
        switch (inputText) {
            case "100":
                myImg.setImageResource(R.drawable.c100);
                myTxt.setText("获得碎片：1块");
                break;
            case "010":
                myImg.setImageResource(R.drawable.c010);
                myTxt.setText("获得碎片：1块");
                break;
            case "001":
                myImg.setImageResource(R.drawable.c001);
                myTxt.setText("获得碎片：1块");
                break;
            case "110":
                myImg.setImageResource(R.drawable.c110);
                myTxt.setText("获得碎片：2块");
                break;
            case "011":
                myImg.setImageResource(R.drawable.c011);
                myTxt.setText("获得碎片：2块");
                break;
            case "101":
                myImg.setImageResource(R.drawable.c101);
                myTxt.setText("获得碎片：2块");
                break;
            case "111":
                myImg.setImageResource(R.drawable.c111);
                myTxt.setText("获得碎片：3块");
                break;
            default:
                myImg.setImageResource(R.drawable.c000);
                myTxt.setText("获得碎片：0块");
                break;
        }
    }

    public String load (){
        FileInputStream in = null;
        BufferedReader reader =  null;
        StringBuilder content = new StringBuilder();
        try {
            //获取FileInputStream对象
            in = openFileInput("KlotskiData");
            //借助FileInputStream对象, 构建出一个BufferedReader对象
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            //通过BufferedReader对象进行一行行的读取, 把文件中的所有内容全部读取出来
            // 并存放在StringBuilder对象中
            while ((line = reader.readLine())!= null){
                content.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //最后将读取到的内容返回
        return  content.toString();
    }
}
