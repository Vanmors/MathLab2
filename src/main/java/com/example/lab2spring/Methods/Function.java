package com.example.lab2spring.Methods;

public class Function {

    public double myFunc(double x) {
        return Math.pow(x, 3) - 4.5 * Math.pow(x, 2) - 9.21 * x - 0.383;
//        return Math.pow(x, 3) - x + 4;
    }

    public double f1(double x) {
        return 3 * Math.pow(x, 2) - 4.5 * 2 * x - 9.21;
//        return 3 * Math.pow(x, 2) - 1;
    }

    public double f2(double x) {
        return 6 * x - 4.5 * 2;
//        return 6 * x;
    }
}