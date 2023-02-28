package com.example.lab2spring.Methods;

import com.example.lab2spring.Tables.TableMethod1;

import java.util.ArrayList;
import java.util.List;

public class Method3 implements Method {
    private double a;
    private double b;
    private double e;

    public Method3(double a, double b, double e) {
        this.a = a;
        this.b = b;
        this.e = e;
    }
//    int a = -2;
//    int b = -1;
//    double e = 0.01;


    @Override
    public List<TableMethod1> method() {
        Function function = new Function();
        List<TableMethod1> tableMethod1s = new ArrayList<>();
        double x0;
        if (function.myFunc(a) < 0 && function.myFunc(b) > 0 && function.f2(a) < 0) {
            x0 = a;
        } else {
            return null;
        }
        double xnMinusPreX = e + 1;
        double xn = x0;
        double xnPlus1 = xn;
        int count = 1;
        while (Math.abs(xnMinusPreX) > e && Math.abs(function.myFunc(xn)) > e) {
            count++;
            xn = xnPlus1;
            xnPlus1 = xn - (function.myFunc(xn) / function.f1(xn));
            System.out.println("xnPlus " + xnPlus1);
            xnMinusPreX = xnPlus1 - xn;
            System.out.println("xMinus " + xnMinusPreX);
        }
        TableMethod1 tableMethod1 = new TableMethod1(count, xn, function.myFunc(xn));
        tableMethod1s.add(tableMethod1);
        return tableMethod1s;
    }
}
