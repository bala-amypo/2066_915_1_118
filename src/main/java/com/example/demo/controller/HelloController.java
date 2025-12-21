package com.example.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Hello API", description = "Sample Hello endpoints")
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello, Swagger UI is working!";
    }
}
