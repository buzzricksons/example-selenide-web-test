package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for Ajax test
 *
 * @author HyungCheol Kim
 */
@Controller
public class ExamWebAppController {
    private final String AJAX_TEMPLATE = "yoda";
    private final String HOME_TEMPLATE = "home";
    /**
     * execute for {@code /top} request
     *
     * @return thymeleaf template name
     */
    @GetMapping("/top")
    public String top() {
        return AJAX_TEMPLATE;
    }

    @RequestMapping("/")
    public String home() {
        return HOME_TEMPLATE;
    }
}
