package com.techreturners.apilab1.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@AutoConfigureMockMvc
@SpringBootTest
public class CoffeeControllerTests {
    //This @Autowired is part of Spring
    //It enables objects(beans) to be injected at runtime by Spring Dependency Injection mechanism
    @Autowired
    private MockMvc mockMvcController;
    @Test
    public void testGetCoffeelover() throws Exception {
        //Arrange, Act and Assert chained within the following statements
        String expectedContent = "I like coffee!";
        this.mockMvcController.perform(
                        //Make a GET request to the '/' endpoint
                        MockMvcRequestBuilders.get("/coffeelover"))
                //Matchers are helpful methods that help you write your assertions
                //According to the requirement, we expect 200 OK Status Code as a Response
                //According to the requirement, we expect the string as a Response
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string
                        (expectedContent));
    }

    @Test
    public void testGetCoffeeWithName() throws Exception {
        //Arrange, Act and Assert chained within the following statements
        String expectedContent = "{\"id\":2,\"name\":\"cappuccino\"}";
        this.mockMvcController.perform(
                        //Make a GET request to the '/' endpoint
                        MockMvcRequestBuilders.get("/coffee?name=cappuccino"))
                //Matchers are helpful methods that help you write your assertions
                //According to the requirement, we expect 200 OK Status Code as a Response
                //According to the requirement, we expect the string as a Response
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json
                        (expectedContent));
    }

    @Test
    public void testGetCoffeeWithoutName() throws Exception {
        //Arrange, Act and Assert chained within the following statements
        String expectedContent = "{\"id\":1,\"name\":\"latte\"}";
        this.mockMvcController.perform(
                        //Make a GET request to the '/' endpoint
                        MockMvcRequestBuilders.get("/coffee"))
                //Matchers are helpful methods that help you write your assertions
                //According to the requirement, we expect 200 OK Status Code as a Response
                //According to the requirement, we expect the string as a Response
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json
                        (expectedContent));
    }
}
