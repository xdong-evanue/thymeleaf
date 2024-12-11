package org.scraper.thymeleaf.controller;

import org.scraper.thymeleaf.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/hello2")
    public String hello2(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello2";
    }

    @RequestMapping("/hello3")
    public String hello3(@RequestParam("id") Integer id, Model model) {
        String name = helloService.getUserName(id);
        model.addAttribute("name", name);
        return "hello3";
    }

}
