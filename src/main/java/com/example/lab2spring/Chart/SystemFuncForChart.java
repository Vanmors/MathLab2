package com.example.lab2spring.Chart;

public class SystemFuncForChart {


    public double systemsExpression1(double x, int number) {
        if (number == 1) {
            return Math.sqrt(4 - Math.pow(x, 2));
        } else if (number == 2) {
            return Math.sqrt(2 - Math.pow(x, 2));

        }
        return Math.sqrt(4 - Math.pow(x, 2));
    }

    public double systemsExpression2(double x, double y, int number) {
        if (number == 1) {
            return 3 * Math.pow(x, 2);
        } else if (number == 2) {
            return 4 * Math.pow(x, 2);
        }
        return y - 3 * Math.pow(x, 2);
    }
}
