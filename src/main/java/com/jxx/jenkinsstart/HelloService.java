package com.jxx.jenkinsstart;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class HelloService {

    public String hello() {
        String prefix = UUID.randomUUID().toString();
        return "hello your ID : " + prefix;
    }
}
