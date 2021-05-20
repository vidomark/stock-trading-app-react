package com.trade.model;

public class Response {
    private final String price;
    private final String symbol;
    private final String message;

    public Response(String price, String symbol, String message) {
        this.price = price;
        this.symbol = symbol;
        this.message = message;
    }

    public String getPrice() {
        return price;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getMessage() {
        return message;
    }
}
