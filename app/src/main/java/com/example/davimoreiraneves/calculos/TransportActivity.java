package com.example.davimoreiraneves.calculos;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


public class TransportActivity extends AppCompatActivity {

    Switch sb_opt;
    TextView budgetLabel;
    EditText budget;
    EditText precoPassagem;
    TextView startDate;
    TextView finalDate;
    EditText goingCarDays;
    EditText fuelPrice;
    EditText carSpending;
    EditText dailyDistance;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport);
        sb_opt = (Switch) findViewById(R.id.chooseCalcOption);
        budgetLabel = (TextView) findViewById(R.id.budgetLabel);
        budget = (EditText) findViewById(R.id.budget);
        precoPassagem = (EditText) findViewById(R.id.pass_cost);
        startDate = (TextView) findViewById(R.id.startDate);
        finalDate = (TextView) findViewById(R.id.finalDate);
        goingCarDays = (EditText) findViewById(R.id.goingCarDays);
        fuelPrice = (EditText) findViewById(R.id.fuelPriceValue);
        carSpending = (EditText) findViewById(R.id.car_spending);
        dailyDistance = (EditText) findViewById(R.id.dailyDistance);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Calendar cal = Calendar.getInstance();
        Date currentLocalTime = cal.getTime();
        DateFormat date = new SimpleDateFormat("HH:mm ss");
// you can get seconds by adding  "...:ss" to it

        String localTime = date.format(currentLocalTime);
        getSupportActionBar().setTitle(localTime);

        switchMonitor(sb_opt);


    }

    private void switchMonitor(Switch sb_opt) {
        sb_opt.setChecked(false);
        sb_opt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    budgetLabel.setVisibility(View.VISIBLE);
                    budget.setVisibility(View.VISIBLE);
                }
                else {
                    budgetLabel.setVisibility(View.INVISIBLE);
                    budget.setVisibility(View.INVISIBLE);

                }
            }

        });
        if(sb_opt.isChecked()){
            budgetLabel.setVisibility(View.VISIBLE);
            budget.setVisibility(View.VISIBLE);
        }
        else {
            budgetLabel.setVisibility(View.INVISIBLE);
            budget.setVisibility(View.INVISIBLE);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_transport, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setingsDefinition(MenuItem item) {

        Intent intent = new Intent(TransportActivity.this, MainActivity.class);
        startActivity(intent);
    }

    //done for learning purposes

    public void showDatePickerDialog(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }
    //done for learning purposes

    public void onClick(View view) {

        final Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH);
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String date = String.valueOf(dayOfMonth) + "-" + String.valueOf(monthOfYear + 1 )
                        + "-" + String.valueOf(year);
                startDate.setText(date);
//
            }
        }, yy, mm, dd);
        datePicker.show();
    }

    public void onfDateClick(View view) {

        final Calendar calendar = Calendar.getInstance();
        int yy = calendar.get(Calendar.YEAR);
        int mm = calendar.get(Calendar.MONTH) + 1;
        int dd = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String date = String.valueOf(dayOfMonth) + "-" + String.valueOf(monthOfYear + 1)
                        + "-" + String.valueOf(year);
                finalDate.setText(date);
//
            }
        }, yy, mm, dd);
        datePicker.show();

    }
}
