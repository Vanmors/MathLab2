package com.example.lab2spring.Chart;

import com.example.lab2spring.Form;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jshell.execution.FailOverExecutionControlProvider;
import lombok.Getter;
import lombok.Setter;
import org.jfree.chart.JFreeChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.jfree.chart.ChartUtils.writeChartAsJPEG;

@Controller

public class UploadChart {
    public static double aChart;
    public static double bChart;
    public static int numberChart;
//
//    public void uploadChart(){
//
//    }


    @GetMapping("/chart")
    public void handleChart(HttpServletResponse response, Form form, Model model, RedirectAttributes redirectAttributes) throws IOException {
        response.setContentType("image/jpeg");
        model.addAttribute("form", form);
        OutputStream out = response.getOutputStream();
        DrawChart drawChart = new DrawChart();

    //        System.out.println(form.getA());
//        redirectAttributes.getFlashAttributes();

//        System.out.println(aChart);
//        System.out.println(bChart);
//        System.out.println(God.numberChart);
        writeChartAsJPEG(out, drawChart.draw(aChart, bChart, numberChart), 400, 400);

    }

    @GetMapping("/chartSystem")
    public void handleChartSystem(HttpServletResponse response, Form form, Model model, RedirectAttributes redirectAttributes) throws IOException {
        response.setContentType("image/jpeg");
        model.addAttribute("form", form);
        OutputStream out = response.getOutputStream();
        DrawChartForSystems drawChart = new DrawChartForSystems();

        //        System.out.println(form.getA());
//        redirectAttributes.getFlashAttributes();

//        System.out.println(aChart);
//        System.out.println(bChart);
//        System.out.println(God.numberChart);
        writeChartAsJPEG(out, drawChart.draw(aChart, bChart, numberChart), 400, 400);

    }

}
