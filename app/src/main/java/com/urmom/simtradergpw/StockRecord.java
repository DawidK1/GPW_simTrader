package com.urmom.simtradergpw;

public class StockRecord {
    String name;
    String ticker;
    String last;
    String percentageChange;

    public StockRecord(String name, String ticker, String last, String percentageChange) {
        this.name = name;
        this.ticker = ticker;
        this.last = last;
        this.percentageChange = percentageChange;
    }

    public String getName() {
        return name;
    }

    public String getTicker() {
        return ticker;
    }

    public String getLast() {
        return last;
    }

    public String getPercentageChange() {
        return percentageChange;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public void setPercentageChange(String percentageChange) {
        this.percentageChange = percentageChange;
    }
}
