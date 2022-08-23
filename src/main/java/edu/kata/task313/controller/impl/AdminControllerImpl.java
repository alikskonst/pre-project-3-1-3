package edu.kata.task313.controller.impl;

import edu.kata.task313.controller.AdminController;
import edu.kata.task313.entity.User;
import edu.kata.task313.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@Controller
@RequestMapping("/admin")
public class AdminControllerImpl implements AdminController {

    private final UserService userService;

    //------------------------------------------------------------------------------------------------------------------

    @Override
    public String pageUsers(ModelMap modelMap) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        modelMap.addAttribute("currentUser", userService.findOne(user.getLogin()));
        modelMap.addAttribute("user", new User());
        modelMap.addAttribute("userList", userService.findAll());
        return "user_panel";
    }

    @Override
    public String save(User user) {
        userService.save(user);
        return "redirect:/admin";
    }

    @Override
    public String remove(Long id) {
        userService.remove(id);
        return "redirect:/admin";
    }
}
