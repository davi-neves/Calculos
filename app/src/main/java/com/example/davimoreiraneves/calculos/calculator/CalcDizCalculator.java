package com.example.davimoreiraneves.calculos.calculator;

/**
 * Created by davimoreiraneves on 21/12/16.
 */

public class CalcDizCalculator {
    public Double run(Double salario, Double benef, Double add) {
        Double result = add + (salario + benef) * 0.10;
        return result;
    }
}
