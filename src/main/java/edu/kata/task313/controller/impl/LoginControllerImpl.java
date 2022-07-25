package edu.kata.task313.controller.impl;

import edu.kata.task313.controller.LoginController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class LoginControllerImpl implements LoginController {

    @Override
    public String login(ModelMap modelMap) {
        return "login";
    }

    @Override
    public String loginError(ModelMap modelMap) {
        modelMap.addAttribute("loginError", true);
        return "login";
    }
}
