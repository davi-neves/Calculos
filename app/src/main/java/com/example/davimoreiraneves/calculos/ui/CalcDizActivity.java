package com.example.davimoreiraneves.calculos.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.example.davimoreiraneves.calculos.R;
import com.example.davimoreiraneves.calculos.controler.CalcDizController;

/**
 * Created by davimoreiraneves on 18/11/16.
 */
public class CalcDizActivity extends Activity{


    CalcDizController controller;
    private TextView vSalario;
    private TextView vBenef;
    private TextView vAdd;
    private CheckBox chkAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcdiz);
        controller = new CalcDizController();
        vSalario = (TextView) findViewById(R.id.vSalario);
        vBenef = (TextView) findViewById(R.id.vBenef);
        //chkAdd = (CheckBox) findViewById(R.id.chkAdd);
        vAdd= (TextView) findViewById(R.id.vAdd);

        //creating Switch and checking if vBenef  must be Enabled
        final Switch sb_vBenef = (Switch) findViewById(R.id.sb_vBenef);
        sb_vBenef.setChecked(false);
        sb_vBenef.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    vBenef.setEnabled(true);
                    sb_vBenef.setText(R.string.noAddBenefits);
                } else {
                   // vAdd.getEditableText().clear();
                    vBenef.setEnabled(false);
                    sb_vBenef.setText(R.string.addBenefits);
                }
            }
        });
       if (sb_vBenef.isChecked()){
            vAdd.setEnabled(true);
           sb_vBenef.setText(R.string.noAddBenefits);
        }
        else
        {
            vAdd.setEnabled(false);
            sb_vBenef.setText(R.string.addBenefits);
        }
        //creating Switch and checking if vAddVadd must be enabled

        final Switch sb_vAdd = (Switch) findViewById(R.id.sb_vAdd);
        sb_vAdd.setChecked(false);
        sb_vAdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    vAdd.setEnabled(true);
                    sb_vAdd.setText(R.string.noAddVAdd);
                }else{
                    vAdd.setEnabled(false);
                    sb_vAdd.setText(R.string.addVAdd);
                }
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
    }

}


//    private String mActivityName;
//    private TextView mStatusView;
//    private TextView mStatusAllView;
//    private StatusTracker mStatusTracker = StatusTracker.getInstance();
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_a);
//        mActivityName = getString(R.string.activity_a);
//        mStatusView = (TextView)findViewById(R.id.status_view_a);
//        mStatusAllView = (TextView)findViewById(R.id.status_view_all_a);
//        mStatusTracker.setStatus(mActivityName, getString(R.string.on_create));
//        Utils.printStatus(mStatusView, mStatusAllView);
//    }
