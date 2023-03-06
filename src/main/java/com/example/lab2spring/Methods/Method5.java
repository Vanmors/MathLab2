package com.example.lab2spring.Methods;

import com.example.lab2spring.Tables.TableMethod1;

import java.util.ArrayList;
import java.util.List;

public class Method5 implements Method {

    private double a;
    private double b;
    private double e;
    private int number;

    public Method5(double a, double b, double e, int number) {
        this.a = a;
        this.b = b;
        this.e = e;
        this.number = number;
    }

    @Override
    public List<TableMethod1> method() {
        List<TableMethod1> tableMethod1s = new ArrayList<>();
        Function function = new Function();
        double start_X, last_X, q, abs;
        double lambda = 1;
        int count = 1;

        lambda = -1 / function.getMax(a, b, number);

        if (function.f1(a, number) < function.f1(b, number)) {
            last_X = b;
        } else {
            last_X = a;
        }
        start_X = function.Fi(last_X, lambda, number);
        q = function.getMaxQ(a, b, lambda, number);
        if (q > 0 && q < 1) {
            abs = Math.abs(start_X - last_X);

            while (abs > e) {
                last_X = start_X;
                start_X = function.Fi(last_X, lambda, number);
                abs = Math.abs(start_X - last_X);
                count++;
            }
            TableMethod1 tableMethod1 = new TableMethod1(count, start_X, function.myFunc(start_X, number));
            tableMethod1s.add(tableMethod1);
            return tableMethod1s;
        }

        return null;
    }
}
