package com.trade.models;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StockAPIService {

    @Autowired
    private final RemoteURLReader remoteURLReader;
    private final String API_PATH = "https://run.mocky.io/v3/9e14e086-84c2-4f98-9e36-54928830c980?stock=%s";

    public StockAPIService(RemoteURLReader remoteURLReader) {
        super();
        this.remoteURLReader = remoteURLReader;
    }

    public Double getPrice(String symbol) throws IOException {
        String url = String.format(API_PATH, symbol);
        String result = remoteURLReader.readFromUrl(url);
        JSONObject json = new JSONObject(result);
        String price = json.get("price").toString();
        return Double.parseDouble(price);
    }

    /** Buys a share of the given stock at the current price. Returns false if the purchase fails */
    public boolean buy() {
        // Stub. No need to implement this.
        return true;
    }

}
