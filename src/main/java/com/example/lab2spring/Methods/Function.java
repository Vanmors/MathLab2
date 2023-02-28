package com.example.lab2spring.Methods;

public class Function {

    public double myFunc(double x) {
//        return Math.pow(x, 3) - 4.5 * Math.pow(x, 2) - 9.21 * x - 0.383;
        return Math.pow(x, 3) - x + 4;
    }

    public double f1(double x) {
//        return 3 * Math.pow(x, 2) - 4.5 * 2 * x - 9.21;
        return 3 * Math.pow(x, 2) - 1;
    }

    public double f2(double x) {
//        return 6 * x - 4.5 * 2;
        return 6 * x;
    }

    public double getMax(double a, double b){
        return Math.max(f1(a), f1(b));
    }

    public double Fi(double x, double lambda) {
        return x + lambda * f1(x);
    }

    public double Fi_(double x, double lambda) {
        return 1 + lambda * f1(x);
    }

    public double getMaxQ(double a, double b, double lambda) {
        return Math.max(Math.abs(Fi_(a, lambda)), Math.abs(Fi_(b, lambda)));
    }

    public double setStartX(double a, double b) {
        if (myFunc(a) * f2(a) > 0) {
            return a;
        } else if (myFunc(b) * f2(b) > 0) {
            return b;
        } else {
            return 1;
        }
    }
}