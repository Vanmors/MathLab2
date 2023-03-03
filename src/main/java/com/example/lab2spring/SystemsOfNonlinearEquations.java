package com.example.lab2spring;

import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping("/")
public class SystemsOfNonlinearEquations {


//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("login");
//        registry.addViewController("/index").setViewName("index");
//        registry.addViewController("/Systems").setViewName("Systems");
//        registry.addViewController("/SystemResult").setViewName("SystemResult");
//        WebMvcConfigurer.super.addViewControllers(registry);
//    }

    @GetMapping("/Systems")
    public String Systems(Model model) {
        model.addAttribute("systemsForm", new SystemsForm());
        return "Systems";

    }



//    @GetMapping("/formSystem")
//    public String save(SystemsForm systemsForm, Model model) {
//        model.addAttribute("formSystems", systemsForm);
//        return "SystemResult";
//    }
    @GetMapping("/formSystem")
    public String save(@ModelAttribute SystemsForm systemsForm) {
//        model.addAttribute("formSystems", systemsForm);
        return "SystemResult";
    }
}
