package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class RecordSymptoms extends AppCompatActivity {
    private CheckBox checkBox1,checkBox2,checkBox3,checkBox4,checkBox5,checkBox7;
    //private CheckBox checkBox8;
  private CheckBox checkBox6;

private Button print;
private TextView text;
ArrayList<String> result;
Button cal;
TextView printCalculate;
Button page_Quarantine_days;


   double  Fever=27.4;
   double dry_cough=16.3;
   double Fatigue =19.3;
   double  loss_of_appetite =11.1;
   double Body_aches =9.7;
   double Shortnees_Of_Breath=8.6;
   double Mucus_or_phlegm =7.5;
   double calculte=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_symptoms);
        checkBox1=findViewById(R.id.ch1);
        checkBox2=findViewById(R.id.ch2);
        checkBox3=findViewById(R.id.ch3);
        checkBox4=findViewById(R.id.ch4);
        checkBox5=findViewById(R.id.ch5);
        checkBox6=findViewById(R.id.ch6);
        checkBox7=findViewById(R.id.ch7);
       // checkBox8=findViewById(R.id.ch8);
        page_Quarantine_days=findViewById(R.id.Quarantine_days);

        //print=findViewById(R.id.print);
        text=findViewById(R.id.printtext);
        result=new ArrayList<>();
        text.setEnabled(false);
        cal=findViewById(R.id.Calculate);
        printCalculate=findViewById(R.id.Calculatetext);

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked()) {
                    result.add("Fever");
                    calculte = calculte + Fever;
                } else
                    result.remove("Fever");
            }
        });
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked()) {
                    result.add("Fatigue");
                    calculte = calculte + Fatigue;
                }
                else
                    result.remove("Fatigue");
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox3.isChecked()) {
                    result.add("Dry cough ");
                    calculte = calculte + dry_cough;
                }
                else
                    result.remove(" Dry cough");
            }
        });
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox4.isChecked()) {
                    result.add("Loss of appetite");
                    calculte = calculte + loss_of_appetite;
                }
                else
                    result.remove("Loss of appetite");
            }
        });
checkBox5.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (checkBox5.isChecked()) {
            result.add(" Body aches");
            calculte = calculte + Body_aches;
        }
        else
            result.remove("Body aches");
    }
});
checkBox7.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        if (checkBox7.isChecked()) {
            result.add("Mucus or phlegm");
            calculte = calculte + Mucus_or_phlegm;
        }
        else
            result.remove("Mucus or phlegm");

    }
});
////checkBox6.setOnClickListener(new View.OnClickListener() {
////    @Override
////    public void onClick(View v) {
////        if (checkBox6.isChecked()) {
////            result.add("Lung Infection");
////            calculte = calculte + lung_infection;
////        }
////        else
////            result.remove("Lung Infection");
////
////
////    }
////});
////checkBox8.setOnClickListener(new View.OnClickListener() {
////    @Override
////    public void onClick(View v) {
////        if (checkBox8.isChecked()) {
////            result.add("Difficulty breathing or shortness of breath");
////            calculte = calculte + Difficulty_breathing;
////
////        }
////        else
////            result.remove("Difficulty breathing or shortness of breath");
////
////    }
//});

//print.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        StringBuilder stringBuilder=new StringBuilder();
//        for (String s: result)
//            stringBuilder.append(s).append(",");
//        text.setText(stringBuilder.toString());
//        text.setEnabled(false);
//    }
//});
    cal.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

           printCalculate.setText(String.valueOf(calculte)+"%");
            printCalculate.setEnabled(false);
            if (calculte >=50)
                printCalculate.setText(String.valueOf(calculte)+"%" +"\n"+"Positive"+","+" Sign Red"+"\n"+"Please go to page Quarantine days ");
else
                printCalculate.setText(String.valueOf(calculte)+"%"+"\n"+" Negative"+","+" Sign Green");


        }
    });
    page_Quarantine_days.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           openActivity2();
           
        }


    });
    }
    private void openActivity2() {
        Intent intent=new Intent(this,Quarantinedays.class);
        startActivity(intent);
    }

}