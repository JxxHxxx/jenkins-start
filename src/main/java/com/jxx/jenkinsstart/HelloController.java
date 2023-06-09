package com.jxx.jenkinsstart;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {
    
    private final HelloService helloService;
    
    @GetMapping("/hello")
    public String hello() {
        String greetings = helloService.hello();
        return greetings;
    }

    @GetMapping("/good-bye")
    public String goodBye() {
        String goodBye = helloService.goodBye();
        return goodBye;
    }

    @GetMapping("/hosts")
    public String getHost() {
        return helloService.getHost();
    }
    
}
