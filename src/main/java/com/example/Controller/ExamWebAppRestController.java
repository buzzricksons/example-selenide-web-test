package com.example.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@RestController
public class ExamWebAppRestController {
    /**
     * Make random seconde from time parameter.
     *
     * @param time second
     * @return Random second from 0 to parameter time.
     */
    @RequestMapping("/get_time")
    public String data(@RequestParam(name="time", required=true, defaultValue = "0") int time) {
        int randomNum = ThreadLocalRandom.current().nextInt(0, time + 1);
        try {
            TimeUnit.SECONDS.sleep(Long.valueOf(randomNum));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Integer.toString(randomNum);
    }
}
