package com.trade.controllers;

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
import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class StockController {

    @Autowired
    StockAPIService stockAPIService;

   /* @Configuration
    @EnableWebMvc
    public class WebConfig extends WebMvcConfigurerAdapter {
        // this method allows cross origin requests
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**");
        }
    }*/

    @CrossOrigin("*")
    @GetMapping("/")
    public HashMap index(@RequestParam Map<String,String> requestParams) throws IOException {
        String symbol = requestParams.get("symbol");
        Double bid = Double.parseDouble(requestParams.get("price"));
        Trader trader = new Trader(stockAPIService);
        HashMap<String, String> response = new HashMap();
        String message;

        boolean purchased = trader.buy(symbol, bid);
        double price = stockAPIService.getPrice(symbol);

        if (purchased) message = "\"Purchased \" + symbol + \" stock at $\" + bid + \", since its higher that the current price ($\" + price + \")\"";
        else message = "Bid for " + symbol + " was $" + bid + " but the stock price is $" + price + ", no purchase was made.";

        response.put("price", String.valueOf(price));
        response.put("symbol", symbol);
        response.put("message", message);

        return response;
    }

}
