package com.example.lab2spring.Methods;

import java.util.ArrayList;

public class Function {

    public double myFunc(double x, int number) {
        if (number == 1) {
            return Math.pow(x, 3) - 4.5 * Math.pow(x, 2) - 9.21 * x - 0.383;
//            return Math.pow(x, 3) - x + 4;
        } else if (number == 2) {
            return Math.pow(x, 3) + 1.41 * Math.pow(x, 2) - 5.472 * x - 7.38;
        } else if (number == 3) {
            return Math.pow(x, 3) - 0.12 * Math.pow(x, 2) - 1.475 * x - 0.192;
        }
        return Math.pow(x, 3) - 4.5 * Math.pow(x, 2) - 9.21 * x - 0.383;

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

    public double[][] f1IterationForSystem(double x, double y, int number) {
        ArrayList<Double> matrixList = new ArrayList<>();
        if (number == 1) {
            matrixList.add(2 * x);
//            System.out.println(2 * x);
            matrixList.add(2 * y);
            matrixList.add(4 - Math.pow(x, 2) - Math.pow(y, 2));
            matrixList.add(-6 * x);
            matrixList.add(1.0);
            matrixList.add(3 * Math.pow(x, 2) - y);
        } else if (number == 2) {
            matrixList.add(2 * x);
            matrixList.add(2 * y);
            matrixList.add(2 - Math.pow(x, 2) - Math.pow(y, 2));
            matrixList.add(-6 * x);
            matrixList.add(1.0);
            matrixList.add(4 * Math.pow(x, 2) - y);
        }
        int size = 2;
        double[][] matrix = new double[size][size + 1];
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size + 1; j++) {
                try {
                    matrix[i][j] = matrixList.get(index);
                } catch (IndexOutOfBoundsException e) {
                    return null;
                }
                index++;
            }
        }
        return matrix;
    }
}