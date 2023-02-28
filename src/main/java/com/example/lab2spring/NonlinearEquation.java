package com.example.lab2spring;


import com.example.lab2spring.Methods.Method1;
import com.example.lab2spring.Methods.Method3;
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
        if (form.getMethod() == 1) {
            Method1 method1 = new Method1(form.getA(), form.getB(), form.getE());
            model.addAttribute("dataOut", method1.method());
        }
        if (form.getMethod() == 3) {
            Method3 method3 = new Method3(form.getA(), form.getB(), form.getE());
            model.addAttribute("dataOut", method3.method());
        }
//        method3.method();
//        System.out.println(form.getA());
//        System.out.println(form.getB());
//        System.out.println(form.getE());

        return "smt";
    }

}
