package com.trade.controller;

import com.trade.model.Response;
import com.trade.model.StockAPIService;
import com.trade.model.Trader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class StockController {

    @Autowired
    StockAPIService stockAPIService;
    @Autowired
    Trader trader;

    @CrossOrigin("*")
    @GetMapping("/")
    public Response index(@RequestParam Map<String,String> requestParams) throws IOException {
        String symbol = requestParams.get("symbol");
        Double bid = Double.parseDouble(requestParams.get("price"));
        String message;

        boolean purchased = trader.buy(symbol, bid);
        double price = stockAPIService.getPrice(symbol);

        if (purchased) message ="Purchased " + symbol + " stock at $" + bid + ", since its higher than the current price $" + price + ".";
        else message = "Bid for " + symbol + " was $" + bid + " but the stock price is $" + price + ", no purchase was made.";

        Response response = new Response(String.valueOf(price), symbol, message);
        return response;
    }

}
