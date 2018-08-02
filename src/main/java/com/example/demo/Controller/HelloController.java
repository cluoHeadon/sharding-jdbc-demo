package com.example.demo.Controller;

import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/5/16 0016.
 */
@RestController("hello")
public class HelloController {
    @Autowired
    DemoService demoService;

    @GetMapping("/test")
    public void test() {
        demoService.demo();
    }
}
