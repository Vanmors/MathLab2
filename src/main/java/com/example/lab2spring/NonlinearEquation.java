package com.example.lab2spring;


import com.example.lab2spring.Chart.DrawChart;
//import com.example.lab2spring.Chart.God;
import com.example.lab2spring.Chart.UploadChart;
import com.example.lab2spring.Methods.Method1;
import com.example.lab2spring.Methods.Method3;
import com.example.lab2spring.Methods.Method5;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.OutputStream;

import static org.jfree.chart.ChartUtils.writeChartAsJPEG;

@Controller
@RequestMapping("/")
public class NonlinearEquation {

    @GetMapping
    public String chooseExpression() {
//        model.addAttribute("expression", new ChooseExpression());
        return "chooseExpression";
    }

    @GetMapping("/lineSegment")
    public String setData(Model model) {
        model.addAttribute("form", new Form());
        return "index";
    }


    //    @GetMapping("/form")
//    public String getData(@ModelAttribute Form form, ChooseExpression chooseExpression) {
//        System.out.println("ok");
//        System.out.println(form.getA());
//        return "smt";
//    }
    @GetMapping(value = "/form")
    public String save(Form form, Model model, RedirectAttributes redirectAttributes, HttpServletResponse response) throws IOException {

        model.addAttribute("form", form);
        model.getAttribute("form");
        redirectAttributes.addFlashAttribute("form", form);
        UploadChart.aChart = form.getA();
        UploadChart.bChart = form.getB();
        UploadChart.numberChart = form.getNumberOfFunction();

//        System.out.println(form.getA());
        if (form.getMethod() == 1) {
            Method1 method1 = new Method1(form.getA(), form.getB(), form.getE(), form.getNumberOfFunction());
            model.addAttribute("dataOut", method1.method());
            model.addAttribute("Chart", "src/main/res/Chart.jpeg");
        }
        if (form.getMethod() == 3) {
            Method3 method3 = new Method3(form.getA(), form.getB(), form.getE(), form.getNumberOfFunction());
            model.addAttribute("dataOut", method3.method());
        }
        if (form.getMethod() == 5) {
            Method5 method5 = new Method5(form.getA(), form.getB(), form.getE(), form.getNumberOfFunction());
            model.addAttribute("dataOut", method5.method());
        }

//        else {
//            return "ErrorPage";
//        }
//        method3.method();
//        System.out.println(form.getA());
//        System.out.println(form.getB());
//        System.out.println(form.getE());
//        response.setContentType("image/jpeg");
//        OutputStream out = response.getOutputStream();
//        DrawChart drawChart = new DrawChart();
//        writeChartAsJPEG(out, drawChart.draw(form.getA(), form.getB(), form.getNumberOfFunction()), 400, 400);
        return "smt";
    }

}
