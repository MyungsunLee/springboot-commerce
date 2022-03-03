package com.bdshopping.springbootbdshopping.controller;

import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@Api
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello Spring Boot Boilerplate!");
    }

    @GetMapping("/hello/error")
    public ResponseEntity<String> sayError() {
        throw new NoSuchElementException("에러를 발생시키는 테스트에요");
    }
}
