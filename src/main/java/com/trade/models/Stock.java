package com.trade.models;

import java.util.HashMap;

public class Stock {

    private String symbol;
    private double price;

    public Stock(HashMap data) {
        String stockSymbol = data.get("symbol").toString();
        double stockPrice = Double.valueOf(data.get("price").toString());

        this.symbol = stockSymbol;
        this.price = stockPrice;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
