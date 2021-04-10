package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btn1;
    TelephonyManager tm;
    TextView imeitxt;
    Button imeibtn;
    String imei;
    private Button button;
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imeitxt = (TextView) findViewById(R.id.imei);
        imeibtn = (Button) findViewById(R.id.getimeibtn);
        btn1=findViewById(R.id.btn1);

        int permisI = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE);

        if (permisI == PackageManager.PERMISSION_GRANTED) {
            tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
            imei = tm.getDeviceId().toString();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 123);
        }

        imeibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imeitxt.setText(imei);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,secondActivity.class);
            startActivity(intent);
            }
        });

    }



}





