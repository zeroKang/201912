package org.zerock.b201912.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloRestController
 */
@RestController

public class HelloRestController {

    @GetMapping("/hello")
    @PreAuthorize(value = "hasRole('ROLE_USER')")
    public String hello(){

        return "Hello World";
    }
    
}