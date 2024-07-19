package com.toy.springbootmavencustombuild.rest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * HelloWorldController 테스트 코드
 *
 * @author readra
 */
@WebMvcTest(HelloWorldController.class)
public class HelloWorldControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Hello World")
    void helloWorldTest() throws Exception {
        mockMvc.perform(get("/v1/hello-world"))
                .andExpect(status().isOk())
                .andExpect(content().string(HelloWorldController.HELLO_WORLD));
    }
}
