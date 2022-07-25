package edu.kata.task313.controller;

import edu.kata.task313.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

public interface AdminController {

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users")
    String pageUsers(ModelMap modelMap);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/create")
    String pageCreate(ModelMap modelMap);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/update/{id}")
    String pageUpdate(ModelMap modelMap, @PathVariable("id") Long id);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/create")
    String create(@ModelAttribute("user") User user);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/update")
    String update(@ModelAttribute("user") User user);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/remove/{id}")
    String remove(@PathVariable("id") Long id);
}
