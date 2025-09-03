package org.aptech.t2311e.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Restfull  , Soap ...
@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public String helloApi(){
        return "Hello World";
    }

}
