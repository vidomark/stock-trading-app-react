package com.trade.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Trader {

    @Autowired
    private final StockAPIService stockAPIService;

    public Trader(StockAPIService stockAPIService) {
        this.stockAPIService = stockAPIService;
    }

    /** Checks the price of a stock, and buys it if the price is not greater than the bid amount.
     * 	@return whether any stock was bought */
    public boolean buy(String symbol, double bid) throws IOException {
        double price = stockAPIService.getPrice(symbol);

        boolean result;
        if (price <= bid) {
            result = true;
            stockAPIService.buy();
        }
        else {
            result = false;
        }
        return result;
    }

}
