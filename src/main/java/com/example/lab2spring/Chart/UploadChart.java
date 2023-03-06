package com.example.lab2spring.Chart;

import com.example.lab2spring.Form;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.OutputStream;


import static org.jfree.chart.ChartUtils.writeChartAsJPEG;

@Controller

public class UploadChart {
    public static double aChart;
    public static double bChart;
    public static int numberChart;


    @GetMapping("/chart")
    public void handleChart(HttpServletResponse response, Form form, Model model, RedirectAttributes redirectAttributes) throws IOException {
        response.setContentType("image/jpeg");
        model.addAttribute("form", form);
        OutputStream out = response.getOutputStream();
        DrawChart drawChart = new DrawChart();

        writeChartAsJPEG(out, drawChart.draw(aChart, bChart, numberChart), 400, 400);

    }

    @GetMapping("/chartSystem")
    public void handleChartSystem(HttpServletResponse response, Form form, Model model, RedirectAttributes redirectAttributes) throws IOException {
        response.setContentType("image/jpeg");
        model.addAttribute("form", form);
        OutputStream out = response.getOutputStream();
        DrawChartForSystems drawChart = new DrawChartForSystems();

        writeChartAsJPEG(out, drawChart.draw(aChart, bChart, numberChart), 400, 400);

    }

}
