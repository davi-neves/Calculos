package com.example.davimoreiraneves.calculos.ui.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by davimoreiraneves on 22/12/16.
 */

public class BaseActivity extends AppCompatActivity {
    private ProgressDialog loading;
    public void showLoading(Context context){
        if(loading == null){
            loading = new ProgressDialog(context);
        }
        if (!loading.isShowing())
            loading.show();
    }

    public void hidenLoading(){
        if(loading != null){
            if (loading.isShowing())
                loading.dismiss();
        }
    }
}
