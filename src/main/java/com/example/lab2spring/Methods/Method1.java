package com.example.lab2spring.Methods;

import com.example.lab2spring.Tables.TableMethod1;

import java.util.ArrayList;
import java.util.List;


public class Method1 implements Method {
    private double a;
    private double b;
    private double e;
    private int number;

    public Method1(double a, double b, double e, int number) {
        this.a = a;
        this.b = b;
        this.e = e;
        this.number = number;
    }


    Function function = new Function();

    @Override
    public List<TableMethod1> method() {
        List<TableMethod1> tableMethod1s = new ArrayList<>();
        double x = e + 1;
        double aMinusB = e + 1;
        int count = 1;
        while (Math.abs(function.myFunc(x, number)) >= e && Math.abs(aMinusB) > e) {
            count++;
            x = (a + b) / 2;
            if (function.myFunc(a, number) * function.myFunc(x, number) > 0) {
                a = x;
            } else {
                b = x;
            }
            aMinusB = a - b;

        }
        x = (a + b) / 2;
        TableMethod1 tableMethod1 = new TableMethod1(count, x, function.myFunc(x, number));
        tableMethod1s.add(tableMethod1);

        return tableMethod1s;
    }


}
