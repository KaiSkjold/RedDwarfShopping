package com.example.reddwarfshopping;

import java.io.Serializable;

public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    public int id;
    public String name;
    public String description;
    public String quote;
    public int seriesNumber;
    public Double price;
    public String image;
    public int quantity;

    public Product(String name, String description, String quote, int seriesNumber, Double price, String image) {
        this.name = name;
        this.description = description;
        this.quote = quote;
        this.seriesNumber = seriesNumber;
        this.price = price;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public int getSeriesNumber() {
        return seriesNumber;
    }

    public void setSeriesNumber(int seriesNumber) {
        this.seriesNumber = seriesNumber;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
