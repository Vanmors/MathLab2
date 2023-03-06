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

@Controller
@RequestMapping("/")
public class NonlinearEquation {

    @GetMapping
    public String chooseExpression() {
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
    public String save(Form form, Model model, RedirectAttributes redirectAttributes) throws IOException {

        model.addAttribute("form", form);
        model.getAttribute("form");
        redirectAttributes.addFlashAttribute("form", form);
        UploadChart.aChart = form.getA();
        UploadChart.bChart = form.getB();
        UploadChart.numberChart = form.getNumberOfFunction();
        if (form.getA() < 7 && form.getB() > -7) {
            if (form.getMethod() == 1) {
                Method1 method1 = new Method1(form.getA(), form.getB(), form.getE(), form.getNumberOfFunction());
                model.addAttribute("dataOut", method1.method());

            }
            if (form.getMethod() == 3) {
                Method3 method3 = new Method3(form.getA(), form.getB(), form.getE(), form.getNumberOfFunction());
                model.addAttribute("dataOut", method3.method());
            }
            if (form.getMethod() == 5) {
                Method5 method5 = new Method5(form.getA(), form.getB(), form.getE(), form.getNumberOfFunction());
                model.addAttribute("dataOut", method5.method());
            }
        } else {
            model.addAttribute("dataOut", null);
        }

        return "smt";
    }

}
