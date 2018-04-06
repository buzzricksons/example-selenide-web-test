package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller for Ajax test
 *
 * @author HyungCheol Kim
 */
@Controller
public class ExamWebAppController {
    private final String TEMPLATE_NAME = "yoda";
    /**
     * execute for {@code /top} request
     *
     * @return thymeleaf template name
     */
    @GetMapping("/top")
    public String top() {
        return TEMPLATE_NAME;
    }
}
