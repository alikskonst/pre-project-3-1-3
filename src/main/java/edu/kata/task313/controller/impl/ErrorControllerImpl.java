package edu.kata.task313.controller.impl;

import edu.kata.task313.controller.ErrorController;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ErrorControllerImpl implements ErrorController {

    @Override
    public String entityNotFoundException(final Throwable throwable, final ModelMap modelMap) {
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        modelMap.addAttribute("errorMessage", errorMessage);
        return "login";
    }

    @Override
    public String runtimeException(final Throwable throwable, final ModelMap modelMap) {
        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        modelMap.addAttribute("errorMessage", errorMessage);
        return "login";
    }
}