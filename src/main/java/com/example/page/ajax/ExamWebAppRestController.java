package com.example.page.ajax;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class ExamWebAppRestController {
    @RequestMapping("/get_time")
    public String data(@RequestParam(name="time", required=true, defaultValue = "0") String time) {
        try {
            TimeUnit.SECONDS.sleep(Long.valueOf(time));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return time;
    }
}
