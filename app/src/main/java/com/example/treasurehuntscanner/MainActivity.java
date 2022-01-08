package com.example.treasurehuntscanner;

import android.Manifest;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static  final String hint_txt="com.example.tresurehuntscanner.example.hint_txt";
    public static  final String hint_lst="com.example.tresurehuntscanner.example.hint_lst";
    public String txt_out;
    public String[] hint_list=new String[]{"I am your trustful 'new version' who is physically tied & emotionally hived, mechanically drived.","Mr lecturer, is 08:02:51, the manufacturing time of my tech-grounded footwear?","I am in the place of valentines, but not that much cornered, 3/4rth of pink, 1/4rth of white","Open/closed wide heart and smiley face are the qualities of me and my conjoined twin. We are 1/4rth of family snap of Invento, and the clue is with me","'Chess' players like me, but I have no Guinness World Record inside. Find your solution by pushing my external body part","You all welcomed me with cheers. I am neither feared with heights nor flying, wow! Is that England?"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent=getIntent();
        String txt=intent.getStringExtra(scanner.hint);
        TextView textView=(TextView)findViewById(R.id.textView);
        txt_out=txt;
        if(txt_out==null)
        {
            Collections.shuffle(Arrays.asList(hint_list));
            txt_out="Scan the QR code to get hint!!";
            textView.setText(txt_out);
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
