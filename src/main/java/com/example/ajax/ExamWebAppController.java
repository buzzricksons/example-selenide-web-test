package com.example.ajax;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Ajaxテスト用のウェブアプリケーションです。
 *
 * @author HyungCheol Kim
 */
@RequestMapping("/time")
@Controller
public class ExamWebAppController {
    /**
     * {@code /top}リクエストに対する処理を行います。
     *
     * @return テンプレート名
     */
    @GetMapping("/top")
    public String top() {
        return "yoda";
    }
}
