package com.example.treasurehuntscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class Hints extends AppCompatActivity {
    public static  final String hint_txt="com.example.tresurehuntscanner.example.hint_txt";
    public static  final String hint_lst="com.example.tresurehuntscanner.example.hint_lst";
    public String txt_out;
    public String[] hint_list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        String txt=intent.getStringExtra(scanner.hint);
        String num;
        TextView textView;
        hint_list=intent.getStringArrayExtra(scanner.hint_lsst);
        num=intent.getStringExtra(scanner.code);
        textView=(TextView)findViewById(R.id.textView);
        txt_out=txt;

        switch (num){
            case "6":txt_out=txt_out+"\n\nPlace 1:\n"+hint_list[0];
                textView.setText(txt_out);
                break;
            /*case 2064:txt_out=txt_out+"\n\nPlace 2:\n"+hint_list[1];
                textView.setText(txt_out);
                break;
            case 3082:txt_out=txt_out+"\n\nPlace 3:\n"+hint_list[2];
                textView.setText(txt_out);
                break;
            case 4094:txt_out=txt_out+"\n\nPlace 4:\n"+hint_list[3];
                textView.setText(txt_out);;
                break;
            case 5052:txt_out=txt_out+"\n\nPlace 5:\n"+hint_list[4];
                textView.setText(txt_out);
                break;
            case 6084:txt_out=txt_out+"\n\nPlace 6:\n"+hint_list[5];
                textView.setText(txt_out);;
                break;
            */
            default:txt_out=txt_out+"\n\nNext clue:\n"+num;
                textView.setText(txt_out);
                break;

        }



    }
    public void scan(View view)
    {
        Intent a2= new Intent(this,scanner.class);
        a2.putExtra(hint_txt,txt_out);
        a2.putExtra(hint_lst,hint_list);
        startActivity(a2);

    }
    @Override
    public void onBackPressed()
    {

    }
}
