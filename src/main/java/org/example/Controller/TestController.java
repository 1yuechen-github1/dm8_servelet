package org.example.Controller;

import org.example.Mapper.TestMapper;
import org.example.entity.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController {

    @Autowired
    private TestMapper testMapper;

    @GetMapping("/hello")
    public String hello() {
        return "<h1 style='color: red; text-align: center'>Hello Spring Boot World~</h1>";
    }

    @GetMapping("/selectAll")
    public void selectAll(){
        List<Exam> exams = testMapper.selectAll();
        System.out.println(exams);
    }

}
