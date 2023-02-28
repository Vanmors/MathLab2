package com.example.lab2spring.Methods;

public class Out {

    public void outMethod2InConsole(int count, double a, double b, double x, double fa, double fb, double fx, double aMinusB) {
        System.out.printf(
                "%1$7d | %2$7f | %3$4f | %4$6f | %5$10.8f | %6$1f | %7$1f | %8$1f%n",
                count, a, b, x, fa, fb, fx, aMinusB);
    }
}