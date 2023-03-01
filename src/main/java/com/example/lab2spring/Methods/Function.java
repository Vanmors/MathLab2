package com.example.lab2spring.Methods;

public class Function {

    public double myFunc(double x, int number) {
        if (number == 1) {
            return Math.pow(x, 3) - 4.5 * Math.pow(x, 2) - 9.21 * x - 0.383;
        } else if (number == 2) {
            return Math.pow(x, 3) + 1.41 * Math.pow(x, 2) - 5.472 * x - 7.38;
        } else if (number == 3) {
            return Math.pow(x, 3) - 0.12 * Math.pow(x, 2) - 1.475 * x - 0.192;
        }
        return Math.pow(x, 3) - 4.5 * Math.pow(x, 2) - 9.21 * x - 0.383;
//        return Math.pow(x, 3) - x + 4;
    }

    public double f1(double x, int number) {

        if (number == 1) {
            return 3 * Math.pow(x, 2) - 4.5 * 2 * x - 9.21;
        } else if (number == 2) {
            return 3 * Math.pow(x, 2) + 2 * 1.41 * x - 5.472;
        } else if (number == 3) {
            return 3 * Math.pow(x, 2) - 2 * 0.12 * x - 1.475;
        }
        return 3 * Math.pow(x, 2) - 4.5 * 2 * x - 9.21;
//        return 3 * Math.pow(x, 2) - 1;
    }

    public double f2(double x, int number) {
        if (number == 1) {
            return 6 * x - 4.5 * 2;
        } else if (number == 2) {
            return 6 * x + 2 * 1.41;
        } else if (number == 3) {
            return 6 * x - 2 * 0.12;
        }
        return 6 * x - 4.5 * 2;
//        return 6 * x;
    }

    public double getMax(double a, double b, int number) {
        return Math.max(f1(a, number), f1(b, number));
    }

    public double Fi(double x, double lambda, int number) {
        return x + lambda * myFunc(x, number);
    }

    public double Fi_(double x, double lambda, int number) {
        return 1 + lambda * f1(x, number);
    }

    public double getMaxQ(double a, double b, double lambda, int number) {
        return Math.max(Math.abs(Fi_(a, lambda, number)), Math.abs(Fi_(b, lambda, number)));
    }

    public double setStartX(double a, double b, int number) {
        if (myFunc(a, number) * f2(a, number) > 0) {
            return a;
        } else if (myFunc(b, number) * f2(b, number) > 0) {
            return b;
        } else {
            return 1;
        }
    }
}