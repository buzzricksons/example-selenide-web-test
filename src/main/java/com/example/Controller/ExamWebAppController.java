package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * App for Ajax test
 *
 * @author HyungCheol Kim
 */
@RequestMapping("/time")
@Controller
public class ExamWebAppController {
    /**
     * execute for {@code /top} request
     *
     * @return thymeleaf template name
     */
    @GetMapping("/top")
    public String top() {
        return "yoda";
    }
}
