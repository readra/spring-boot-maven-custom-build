package com.toy.springbootmavencustombuild.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 예제 Controller Layer
 *
 * @author readra
 */
@RestController
@RequestMapping("/v1")
public class HelloWorldController {
    public static final String HELLO_WORLD = "Hello World";

    /**
     * 안녕하세요!
     *
     * @return
     *      안녕하세요!
     */
    @GetMapping("/hello-world")
    public String helloWorld() {
        return HELLO_WORLD;
    }
}
