package com.quizApp.Quiz_app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping(path = "/basicauth")
    public String basicAuthCheck() {
        return "Success";
    }
}
