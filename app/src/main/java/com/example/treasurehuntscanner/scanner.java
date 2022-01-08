package com.example.treasurehuntscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Intent;

import com.google.zxing.Result;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class scanner extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView scannerView;
    public static  final String code="com.example.tresurehuntscanner.example.code";
    public static  final String hint="com.example.tresurehuntscanner.example.hint";
    public static  final String hint_lsst="com.example.tresurehuntscanner.example.hint_lsst";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        scannerView = (ZXingScannerView)findViewById(R.id.zxscan);



        Dexter.withActivity(this)
                .withPermission(Manifest.permission.CAMERA)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        scannerView.setResultHandler(scanner.this);
                        scannerView.startCamera();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        Toast.makeText(scanner.this, "You must accept this permission to continue.", Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

                    }
                })
                .check();
    }


    @Override
    protected void onDestroy() {
        scannerView.stopCamera();
        super.onDestroy();
    }

    @Override
    public void handleResult(Result rawResult) {
        String key= rawResult.getText();
        Intent intent=getIntent();
        String text=intent.getStringExtra(MainActivity.hint_txt);
        if(text=="Scan the QR code to get hint!!")
        {
            String[] hintxt=intent.getStringArrayExtra(MainActivity.hint_lst);
            Intent back=new Intent(getApplicationContext(),Hints.class);
            back.putExtra(code,key);
            back.putExtra(hint,text);
            back.putExtra(hint_lsst,hintxt);
            startActivity(back);
        }
        else
        {
            String[] hintxt=intent.getStringArrayExtra(Hints.hint_lst);
            Intent back=new Intent(getApplicationContext(),Hints.class);
            back.putExtra(code,key);
            back.putExtra(hint,text);
            back.putExtra(hint_lsst,hintxt);
            startActivity(back);

        }

    }

}
