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
        modelMap.addAttribute("userList", userService.findAll());
        return "user_panel";
    }

    @Override
    public String pageCreate(ModelMap modelMap) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        modelMap.addAttribute("currentUser", userService.findOne(user.getLogin()));
        modelMap.addAttribute("user", new User());
        return "user_manage";
    }

    @Override
    public String pageUpdate(ModelMap modelMap, Long id) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        modelMap.addAttribute("currentUser", userService.findOne(user.getLogin()));
        modelMap.addAttribute("user", userService.findOne(id));
        return "user_manage";
    }

    @Override
    public String create(User user) {
        userService.save(user);
        return "redirect:/user_panel";
    }

    @Override
    public String update(User user) {
        userService.save(user);
        return "redirect:/user_panel";
    }

    @Override
    public String remove(Long id) {
        userService.remove(id);
        return "redirect:/user_panel";
    }
}
