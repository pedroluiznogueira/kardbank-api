package com.github.pedroluiznogueira.kardbankapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    @GetMapping
    public String log() {
        return "CI/CD working fine";
    }
}
