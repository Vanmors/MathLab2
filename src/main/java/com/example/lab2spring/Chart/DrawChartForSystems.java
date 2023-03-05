package com.example.lab2spring.Chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.io.File;
import java.io.IOException;

public class DrawChartForSystems {
    SystemFuncForChart systemFuncForChart = new SystemFuncForChart();

    private JFreeChart rawDraw(XYSeriesCollection lineDataset) {


        JFreeChart lineChart = ChartFactory.createXYLineChart(
                "f(x)", "x",
                "y",
                lineDataset, PlotOrientation.VERTICAL,
                true, true, false);

        int width = 1920;
        int height = 1080;


//        UploadChart uploadChart = new UploadChart();
//        uploadChart.setChart(lineChart);

        try {
            ChartUtils.saveChartAsJPEG(new File("src/main/res/Chart.jpeg"), lineChart, width, height);


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lineChart;
    }


    public void drawForIteration(double a, double b, double lambda, int number) {
        XYSeriesCollection lineDataset = new XYSeriesCollection();

        a = a - 1;
        b = b + 1;

        XYSeries function = new XYSeries("function");

        double len = b - a;
        for (double i = a; i <= b; i += len / 12) {
//            function.add(i,i - lambda * systemFuncForChart.systemsExpression1(i, number));
        }

        XYSeries zero = new XYSeries("zero");
        zero.add(a, 0);
        zero.add(b, 0);


        lineDataset.addSeries(function);
        lineDataset.addSeries(zero);

        rawDraw(lineDataset);

    }

    public JFreeChart draw(double a, double b, int number) {
        XYSeriesCollection lineDataset = new XYSeriesCollection();

//        a = a - 1;
//        b = b + 1;
        double x = 1;
        double y = 2;
        XYSeries function1 = new XYSeries("function1");
        XYSeries function2 = new XYSeries("function2");
        XYSeries function3 = new XYSeries("function3");
        double len = 4;
        for (double i = 2; i >= -2; i -= len / 12) {
//            System.out.println("i " + i);
            System.out.println(systemFuncForChart.systemsExpression1(i, 1));
            function1.add(i,  systemFuncForChart.systemsExpression1(i, 1));
        }
        for (double i = 2; i >= -2; i -= len / 12) {
//            System.out.println("i " + i);
            System.out.println(-1 * systemFuncForChart.systemsExpression1(i, 1));
            function3.add(i, -1 * systemFuncForChart.systemsExpression1(i, 1));
        }

        for (double i = -1; i <= 1; i += len / 12) {
//            System.out.println(systemFuncForChart.systemsExpression2(i, 1, 1));
            function2.add(i, systemFuncForChart.systemsExpression2(i, 1, 1));
        }
        XYSeries zero = new XYSeries("zero");
        zero.add(-3, 0);
        zero.add(3, 0);


        lineDataset.addSeries(function1);
        lineDataset.addSeries(function2);
        lineDataset.addSeries(function3);
        lineDataset.addSeries(zero);

        return rawDraw(lineDataset);

    }
}
