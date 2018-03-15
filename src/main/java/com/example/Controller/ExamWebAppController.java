package com.example.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * App for Ajax test
 *
 * @author HyungCheol Kim
 */
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
