package org.scraper.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/hello2")
    public String hello2(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello2";
    }

}
