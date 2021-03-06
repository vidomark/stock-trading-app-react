package com.trade.controllers;

import com.trade.models.Stock;
import com.trade.models.StockAPIService;
import com.trade.models.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class StockController {

    @Autowired
    Stock stock;
    @Autowired
    StockAPIService stockAPIService;

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
    public Stock index(@RequestParam Map<String,String> requestParams) throws IOException {
        String symbol = requestParams.get("symbol");
        Double price = Double.parseDouble(requestParams.get("price"));
        Trader trader = new Trader(stockAPIService);

        boolean purchased = trader.buy(symbol, price);

        return stock;
    }

}
