package com.trade.models;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

public class StockAPIService {

    private String symbol;
    private String price;
    private String API_PATH = "https://run.mocky.io/v3/9e14e086-84c2-4f98-9e36-54928830c980?stock=%s";
    private final RemoteURLReader remoteURLReader;
    private HashMap<String, String> data = new HashMap();

    public StockAPIService(String symbol, String price) {
        this.symbol = symbol;
        this. price = price;
        remoteURLReader = new RemoteURLReader();
    }

    public JSONObject fetchStockData() throws IOException {
        String url = String.format(API_PATH, symbol);
        String result = remoteURLReader.readFromUrl(url);
        JSONObject json = new JSONObject(result);
        return json;
    }

    public HashMap getData(JSONObject json) {
        String symbol = json.get("symbol").toString();
        String price =  json.get("price").toString();

        data.put("symbol", symbol);
        data.put("price", price);

        return data;
    }

}
