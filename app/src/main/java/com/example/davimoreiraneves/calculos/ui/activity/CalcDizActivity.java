package com.example.davimoreiraneves.calculos.ui.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.davimoreiraneves.calculos.R;
import com.example.davimoreiraneves.calculos.controler.CalcDizController;

/**
 * Created by davimoreiraneves on 18/11/16.
 */
public class CalcDizActivity extends BaseActivity{

    Context context = this;
    CalcDizController controller;
    private EditText vSalario;
    private EditText vBenef;
    private EditText vAdd;
    private CheckBox chkAdd;
    private  TextView tvResult;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calcdiz);
        controller = new CalcDizController();
        vSalario = (EditText) findViewById(R.id.vSalario);
        vBenef = (EditText) findViewById(R.id.vBenef);
        //chkAdd = (CheckBox) findViewById(R.id.chkAdd);
        vAdd= (EditText) findViewById(R.id.vAdd);
        tvResult = (TextView) findViewById(R.id.tvResult);
        toolbar = (Toolbar) findViewById(R.id.toolbarCalcDiz);
        setSupportActionBar(toolbar);
        //creating Switch and checking if vBenef  must be Enabled
        final Switch sb_vBenef = (Switch) findViewById(R.id.sb_vBenef);
        sb_vBenef.setChecked(false);
        sb_vBenef.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    vBenef.setEnabled(true);
//                    sb_vBenef.setText(R.string.noAddBenefits);
                } else {
                   // vAdd.getEditableText().clear();
                    vBenef.setEnabled(false);
//                    sb_vBenef.setText(R.string.addBenefits);
                }
            }
        });
//       if (sb_vBenef.isChecked()){
//            vAdd.setEnabled(true);
////           sb_vBenef.setText(R.string.noAddBenefits);
//        }
//        else
//        {
//            vAdd.setEnabled(false);
////            sb_vBenef.setText(R.string.addBenefits);
//        }
        //creating Switch and checking if vAddVadd must be enabled

        final Switch sb_vAdd = (Switch) findViewById(R.id.sb_vAdd);
        sb_vAdd.setChecked(false);
        sb_vAdd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    vAdd.setEnabled(true);
//                    sb_vAdd.setText(R.string.noAddVAdd);
                }else{
                    vAdd.setEnabled(false);
//                    sb_vAdd.setText(R.string.addVAdd);
                }
            }
        });



    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public void getCalcDizResult(View view) {

        showLoading(this);
        Double calcDizResul = controller.getCalcDizResult(vSalario,vBenef,vAdd);
        hidenLoading();
        getSupportActionBar().setTitle(getText(R.string.vDiz)+ String.valueOf(calcDizResul)+"0");
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
