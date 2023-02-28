package com.example.lab2spring;


import com.example.lab2spring.Methods.Method1;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/form")
    public String save(Form form, Model model) {
        model.addAttribute("form", form);
        Method1 method1 = new Method1(form.getA(), form.getB(), form.getE());
//        System.out.println(form.getA());
//        System.out.println(form.getB());
//        System.out.println(form.getE());
        model.addAttribute("dataOut", method1.method());
        return "smt";
    }

}
