package com.trade.controllers;

import com.trade.models.Stock;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Map;

@CrossOrigin("*")
@RestController
public class StockController {

    Stock stock;

    @Configuration
    @EnableWebMvc
    public class WebConfig extends WebMvcConfigurerAdapter {
        // this method allows cross origin requests
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**");
        }
    }

    @CrossOrigin("*")
    @GetMapping("/")
    public String index(@RequestParam Map<String,String> requestParams) {

        return "Hello World";
    }

}
