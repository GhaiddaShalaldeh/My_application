package com.example.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class therdActivity extends AppCompatActivity implements View.OnClickListener {
Button backBtn;
private CardView News,Information,RecordSymptoms,Notification,GPs,Help;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therd);
        backBtn=findViewById(R.id.backBtn);
        News=findViewById(R.id.news);
        Information=findViewById(R.id.information);
        RecordSymptoms=findViewById(R.id.symptoms);
        Notification=findViewById(R.id.notification);
        GPs=findViewById(R.id.gps);
        Help=findViewById(R.id.help);

        News.setOnClickListener(this);
        Information.setOnClickListener(this);
        RecordSymptoms.setOnClickListener(this);
        Notification.setOnClickListener(this);
        GPs.setOnClickListener(this);
        Help.setOnClickListener(this);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onclick for btn1
                startActivity(new Intent(therdActivity.this,secondActivity.class));
            }
        });

    }

    @Override
    public void onClick(View v) {
        //onclick for cardview News,Information,RecordSymptoms,Notification,GPs,Help
Intent i;
switch ((v.getId())){
    case R.id.news:i=new Intent(this,News.class);startActivity(i);

    break;
    case R.id.information:i=new Intent(this,Information.class);startActivity(i);

        break;
    case R.id.symptoms:i=new Intent(this,RecordSymptoms.class);startActivity(i);

        break;
    case R.id.notification:i=new Intent(this,Notification.class);startActivity(i);

        break;
    case R.id.gps:i=new Intent(this,GPS.class);startActivity(i);

        break;
    case R.id.help:i=new Intent(this,Help.class);startActivity(i);

break;
    default:break;
}
    }
}