package com.application.firstapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping(path = "/greetz")
   private String Hello() {
        return  "Hello";
    }
}
