package com.jxx.jenkinsstart;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HelloServiceTest {

    @DisplayName("Simple Test")
    @Test
    void hello() {
        HelloService helloService = new HelloService();
        String greetings = helloService.hello();

        Assertions.assertThat(greetings).startsWith("hello");
    }

    @DisplayName("Simple Test 2")
    @Test
    void isTrue() {
        HelloService helloService = new HelloService();
        String goodBye = helloService.goodBye();
        Assertions.assertThat(goodBye).isEqualTo("good bye");
    }
}