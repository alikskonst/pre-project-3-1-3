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
    @GetMapping
    String pageUsers(ModelMap modelMap);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/save")
    String save(@ModelAttribute("user") User user);

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/remove/{id}")
    String remove(@PathVariable("id") Long id);
}
