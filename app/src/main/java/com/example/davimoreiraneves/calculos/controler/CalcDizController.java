package com.example.davimoreiraneves.calculos.controler;

import android.content.Context;
import android.widget.TextView;

import com.example.davimoreiraneves.calculos.calculator.CalcDizCalculator;

import java.util.Timer;

/**
 * Created by davimoreiraneves on 20/12/16.
 */

public class CalcDizController {
    public Double getCalcDizResult(TextView vSalario, TextView vBenef, TextView vAdd) {
        CalcDizCalculator calculator = new CalcDizCalculator();
        Double salario, benef, add, result;

        if (!vSalario.getText().toString().equalsIgnoreCase("")){
            salario = Double.parseDouble(vSalario.getText().toString().replace(",","."));
        }
        else{
            salario = 00.00;
        }
        if (!vBenef.getText().toString().equalsIgnoreCase("")){
            benef = Double.parseDouble(vBenef.getText().toString().replace(",","."));
        }
        else{
            benef = 00.00;
        }
        if (!vAdd.getText().toString().equalsIgnoreCase("")){
            add = Double.parseDouble(vAdd.getText().toString().replace(",","."));
        }
        else{
            add = 00.00;
        }
        result = calculator.run(salario,benef,add);
        return result;
    }
}
