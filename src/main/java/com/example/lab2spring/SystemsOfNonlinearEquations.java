package com.example.lab2spring;

import com.example.lab2spring.Chart.UploadChart;
import com.example.lab2spring.Methods.MethodForSystem;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class SystemsOfNonlinearEquations {


    @GetMapping("/Systems")
    public String Systems(Model model) {
        model.addAttribute("systemsForm", new SystemsForm());
        return "Systems";

    }

    @GetMapping("/formSystem")
    public String save(SystemsForm systemsForm, Model model) {
        if (systemsForm.getNumberOfSystem() == 1 || systemsForm.getNumberOfSystem() == 2) {
            UploadChart.numberChart = systemsForm.getNumberOfSystem();
            MethodForSystem m = new MethodForSystem(systemsForm.getNumberOfSystem(), systemsForm.getX0(), systemsForm.getY0(), systemsForm.getE());

            model.addAttribute("formSystems", m.method());
        }
        else {
            model.addAttribute("formSystems", null);
        }
        return "SystemResult";
    }
}
