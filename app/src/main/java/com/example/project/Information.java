package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Information extends AppCompatActivity {
Button video;
Button page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
    video=findViewById(R.id.watch);
    page=findViewById(R.id.page);
page.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        gotoUrl("http://site.moh.ps/");

    }
});
    video.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            gotoUrl("https://www.youtube.com/watch?v=rhQ1PAsnvec");
                
        }



    });
    }
    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}