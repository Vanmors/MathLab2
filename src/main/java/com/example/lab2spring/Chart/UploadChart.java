package com.example.lab2spring.Chart;

import com.example.lab2spring.Form;
import jakarta.servlet.http.HttpServletResponse;
import jdk.jshell.execution.FailOverExecutionControlProvider;
import lombok.Getter;
import lombok.Setter;
import org.jfree.chart.JFreeChart;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.jfree.chart.ChartUtils.writeChartAsJPEG;

@Controller

public class UploadChart {

    public double aChart;
    public double bChart;
    public int numberChart;
//
//    public void uploadChart(){
//
//    }

    @RequestMapping("/reports")
    public void handleReports(HttpServletResponse response) throws IOException {
        response.setContentType("image/jpeg");
        OutputStream out = response.getOutputStream();
        DrawChart drawChart = new DrawChart();
//        Form form = new Form();
        writeChartAsJPEG(out, drawChart.draw(aChart, bChart, numberChart), 400, 400);
    }

}
