package com.example.davimoreiraneves.calculos.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.davimoreiraneves.calculos.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calcDiz(View view) {

        //must Start a New activity to calc Diz
        Intent intent = new Intent(MainActivity.this,CalcDizActivity.class);
        startActivity(intent);
    }

    public void calcTransp(View view) {
        //must Start a New activity to calc transport
        Intent intent = new Intent(MainActivity.this,TransportActivity.class);
        startActivity(intent);
    }

    public void calcNewJob(View view) {
        //must Start a New activity to calc NewJob

    }
}
//
//    public void startActivityB(View v) {
//        Intent intent = new Intent(ActivityA.this, ActivityB.class);
//        startActivity(intent);
//    }