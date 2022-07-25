package edu.kata.task313.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

public interface LoginController {

    @GetMapping
    String index();

    @GetMapping("/login")
    String login();

    @GetMapping("/loginError")
    String loginError(ModelMap modelMap);
}
