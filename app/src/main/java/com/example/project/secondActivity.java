package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class secondActivity extends AppCompatActivity {
    Button btn1;
Button backBtn;
    Button button;
    Context context;
    Intent intent1;
    TextView textview;
    LocationManager locationManager ;
    boolean GpsStatus ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
       btn1=findViewById(R.id.btn1);
        backBtn=findViewById(R.id.backBtn);
        button = (Button)findViewById(R.id.button1);
        textview = (TextView)findViewById(R.id.textView1);
        context = getApplicationContext();
        CheckGpsStatus();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                intent1 = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent1);
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(secondActivity.this,MainActivity.class) );
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(secondActivity.this,therdActivity.class);
                startActivity(intent);

            }
        });
    }
    public void CheckGpsStatus(){
        locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        assert locationManager != null;
        GpsStatus = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        if(GpsStatus == true) {
            textview.setText("GPS Is Enabled");
        } else {
            textview.setText("GPS Is Disabled");
        }
    }
}