package com.example.lab2spring.Methods;

import com.example.lab2spring.Tables.TableMethod1;

import java.util.ArrayList;
import java.util.List;

public class Method1 implements Method {
    private double a;
    private double b;
    private double e;

    public Method1(double a, double b, double e) {
        this.a = a;
        this.b = b;
        this.e = e;
    }

    Function function = new Function();
    Out out = new Out();

    @Override
    public List<TableMethod1> method() {
        List<TableMethod1> tableMethod1s = new ArrayList<>();
        double x = e + 1;
        double aMinusB = e + 1;
        int count = 1;
        while (Math.abs(function.myFunc(x)) >= e && Math.abs(aMinusB) > e) {
            out.outMethod2InConsole(count, a, b, x, function.myFunc(a), function.myFunc(b), function.myFunc(x), Math.abs(aMinusB));
//            TableMethod1 tableMethod1 = new TableMethod1(count, x, function.myFunc(x));
//            tableMethod1s.add(tableMethod1);
            count++;
            x = (a + b) / 2;
            if (function.myFunc(a) * function.myFunc(x) > 0) {
                a = x;
            } else {
                b = x;
            }
            aMinusB = a - b;

        }
//        System.out.println(Math.abs(function.myFunc(x)));
////        System.out.println(Math.abs(aMinusB));
        x = (a + b) / 2;
        out.outMethod2InConsole(count, a, b, x, function.myFunc(a), function.myFunc(b), function.myFunc(x), Math.abs(aMinusB));
        TableMethod1 tableMethod1 = new TableMethod1(count, x, function.myFunc(x));
        tableMethod1s.add(tableMethod1);
//        System.out.println(x);
//        System.out.println(function.myFunc(x));
//        System.out.println(count + 1);
        return tableMethod1s;
    }
}
