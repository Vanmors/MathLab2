package com.example.lab2spring;

import com.example.lab2spring.Chart.DrawChartForSystems;
import com.example.lab2spring.Methods.Function;
import com.example.lab2spring.Methods.MethodForSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;

import java.util.ArrayList;

@SpringBootApplication
public class Lab2SpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab2SpringApplication.class, args);
        DrawChartForSystems drawChartForSystems = new DrawChartForSystems();
        drawChartForSystems.draw(1,1,1);
    }

}
