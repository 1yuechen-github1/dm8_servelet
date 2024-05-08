package org.example.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hello")
    public String hello() {
        return "<h1 style='color: red; text-align: center'>Hello Spring Boot World~</h1>";
    }
}
