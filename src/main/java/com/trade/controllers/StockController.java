package com.trade.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin("*")
@RestController
public class StockController {

    @CrossOrigin("*")
    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

}
