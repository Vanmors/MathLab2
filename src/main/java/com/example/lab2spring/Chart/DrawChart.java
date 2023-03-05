package com.example.lab2spring.Chart;

import com.example.lab2spring.Methods.Function;
import jakarta.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.ChartUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import static org.jfree.chart.ChartUtils.writeChartAsJPEG;

public class DrawChart {
    Function functions = new Function();

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

//        try {
//            ChartUtils.saveChartAsJPEG(new File("src/main/res/Chart.jpeg"), lineChart, width, height);
//
//
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
        return lineChart;
    }



    public void drawForIteration(double a, double b, double lambda, int number) {
        XYSeriesCollection lineDataset = new XYSeriesCollection ();

        a = a - 1;
        b = b + 1;

        XYSeries function = new XYSeries("function");

        double len = b-a;
        for (double i = a; i <= b; i+=len/12) {
            function.add(i,i - lambda * functions.myFunc(i, number));
        }

        XYSeries zero = new XYSeries("zero");
        zero.add(a,0);
        zero.add(b,0);


        lineDataset.addSeries(function);
        lineDataset.addSeries(zero);

        rawDraw(lineDataset);

    }

    public JFreeChart draw(double a, double b, int number){
        XYSeriesCollection lineDataset = new XYSeriesCollection ();

        a = a - 1;
        b = b + 1;

        XYSeries function = new XYSeries("function");
        double len = b-a;
        for (double i = a; i <= b; i+=len/12) {
            function.add(i,functions.myFunc(i, number));
        }

        XYSeries zero = new XYSeries("zero");
        zero.add(a,0);
        zero.add(b,0);


        lineDataset.addSeries(function);
        lineDataset.addSeries(zero);

        return rawDraw(lineDataset);

    }
}
