package com.trade.controllers;

import com.trade.models.StockAPIService;
import com.trade.models.Stock;
import org.json.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.IOException;
import java.util.HashMap;
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
    public Stock index(@RequestParam Map<String,String> requestParams) throws IOException {
        String symbol = requestParams.get("symbol");
        String price = requestParams.get("price");

        StockAPIService stockAPIService = new StockAPIService(symbol, price);
        JSONObject json = stockAPIService.fetchStockData();
        HashMap<String, String> data = stockAPIService.getData(json);

        Stock stock = new Stock(data);
        return stock;
    }

}
