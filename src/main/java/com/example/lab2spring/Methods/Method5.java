package com.example.lab2spring.Methods;

import com.example.lab2spring.Tables.TableMethod1;

import java.util.ArrayList;
import java.util.List;

public class Method5 implements Method {

    private double a;
    private double b;
    private double e;

    public Method5(double a, double b, double e) {
        this.a = a;
        this.b = b;
        this.e = e;
    }

    @Override
    public List<TableMethod1> method() {
        List<TableMethod1> tableMethod1s = new ArrayList<>();
        Function function = new Function();
        double start_X, last_X, q, abs;
        double lambda = 1;
        int count = 0;

        lambda = -1 / function.getMax(a, b);
        last_X = function.setStartX(a, b);
        start_X = function.Fi(last_X, lambda);

        q = function.getMaxQ(a, b, lambda);
        System.out.println(q);
        System.out.println("lamda " + lambda);
        if (q > 0 && q < 1) {
            abs = Math.abs(start_X - last_X);

            while (abs > e) {

                last_X = start_X;
                start_X = function.Fi(last_X, lambda);
                abs = Math.abs(start_X - last_X);
                count++;
                System.out.println(count);
                System.out.println("startX" + start_X);
                System.out.println("f(x)" + function.myFunc(start_X));
            }
//            System.out.println(count);
//            System.out.println(start_X);
//            System.out.println(function.myFunc(start_X));
            TableMethod1 tableMethod1 = new TableMethod1(count, start_X, function.myFunc(start_X));
            tableMethod1s.add(tableMethod1);
            return tableMethod1s;
        }

        return null;
    }
}
