package org.example.Controller.K8sApi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("k8s")
public class Test {
    @GetMapping
    public String test() {
        return "请求成功";
    }
}
