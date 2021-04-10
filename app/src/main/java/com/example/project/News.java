package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class News extends AppCompatActivity  {
Button Vaccine;
Button webpage;
AnyChartView anyChartView;
String[]  Cases={"Active Cases","Cases of recovery","Death cases"};
int [] number={21804,191839,2343};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Vaccine=findViewById(R.id.Vaccine);
        webpage=findViewById(R.id.webpage);
anyChartView=findViewById(R.id.any_chart_view);
        setupPioChart();
        Vaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.youtube.com/watch?v=CnrvA8NSBPQ");

            }
        });
        webpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("http://site.moh.ps/index/covid19/");

            }
        });
//        Pie pie=AnyChart.pie();
//        List<DataEntry>data=new ArrayList<>();
//        data.add(new ValueDataEntry("Girle",109180));
//        data.add(new ValueDataEntry("Boy",108883));
//        pie.data(data);
//        AnyChartView anyChartView=(AnyChartView) findViewById(R.id.any_chart_view);
//        anyChartView.setChart(pie);


//        Pie pie1=AnyChart.pie();
//        List<DataEntry>data1=new ArrayList<>();
//        data1.add(new ValueDataEntry("Girle",109180));
//        data1.add(new ValueDataEntry("Boy",108883));
//        pie1.data(data1);
//        AnyChartView anyChartView1=(AnyChartView) findViewById(R.id.any_chart_view1);
//        anyChartView1.setChart(pie1);






    }


    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
    public void setupPioChart()
    {
        Pie pie= AnyChart.pie();
        List<DataEntry> dataEntries=new ArrayList<>();
        for(int i=0;i<Cases.length;i++)
        {
            dataEntries.add(new ValueDataEntry(Cases[i],number[i]));

        }
pie.data(dataEntries);
        anyChartView.setChart(pie);

    }

}