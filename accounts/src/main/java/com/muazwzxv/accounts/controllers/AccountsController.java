package com.muazwzxv.accounts.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @GetMapping("sayHello")
    public String SayHello() {
        return "Hello fuck you not fucking World";
    }
}
