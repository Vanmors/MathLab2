package com.example.lab2spring.Methods;

import com.example.lab2spring.Tables.TableMethod1;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class MethodForSystem implements Method {

    private int number;
    private double x0;
    private double y0;
    private double e;


    @Override
    public List<TableMethod1> method() {
        Function function = new Function();
        List<TableMethod1> tableMethod1s = new ArrayList<>();
        int count = 0;
        while (x0 > e || y0 > e) {
            double xOld = x0;
            double yOld = y0;
            double[] newXY = GaussSolution(function.f1IterationForSystem(x0, y0, number));
            x0 = x0 + newXY[0];
            y0 = y0 + newXY[1];
            if (xOld == x0 && yOld == y0){
                break;
            }
//            System.out.println(x0);
//            System.out.println(y0);
            count++;
//            if (count == 10){
//                break;
//            }

//
//            if (x0 <= e && y0 <= e) {
//                break;
//            }
        }
//        System.out.println(x0);
//        System.out.println(y0);
        TableMethod1 tableMethod1 = new TableMethod1(count, x0, y0);
        tableMethod1s.add(tableMethod1);
        return tableMethod1s;
        }

        public static double[] GaussSolution ( double matrix[][]){
            XYForm xyForm = new XYForm();
            int n = matrix.length;
            double[] x = new double[n];

            // Прямой ход метода Гаусса
            for (int k = 0; k < n; k++) {
                double max = Math.abs(matrix[k][k]);
                int maxRow = k;
                for (int i = k + 1; i < n; i++) {
                    if (Math.abs(matrix[i][k]) > max) {
                        max = Math.abs(matrix[i][k]);
                        maxRow = i;
                    }
                }

                // Перестановка строк
                if (maxRow != k) {
                    double[] temp = matrix[k];
                    matrix[k] = matrix[maxRow];
                    matrix[maxRow] = temp;
                }

                for (int i = k + 1; i < n; i++) {
                    double factor = matrix[i][k] / matrix[k][k];
                    for (int j = k + 1; j <= n; j++) {
                        matrix[i][j] -= factor * matrix[k][j];
                    }
                }
            }

            // Обратный ход метода Гаусса
            for (int i = n - 1; i >= 0; i--) {
                double sum = 0.0;
                for (int j = i + 1; j < n; j++) {
                    sum += matrix[i][j] * x[j];
                }
                x[i] = (matrix[i][n] - sum) / matrix[i][i];
            }

            return x;
        }
    }
