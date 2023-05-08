package com.jxx.jenkinsstart;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelloServiceTest {

    @DisplayName("Simple Test")
    @Test
    void hello() {
        HelloService helloService = new HelloService();
        String greetings = helloService.hello();

        Assertions.assertThat(greetings).startsWith("hello");
    }
}