package com.example.reddwarfshopping;

public class Product {

    public int Id;
    public String Name;
    public String Description;
    public String Quote;
    public int SeriesNumber;
    public Double Price;
    public int Image;
    public int Quantity;

    public Product(String name, String description, String quote, int seriesNumber, Double price, int image) {
        Name = name;
        Description = description;
        Quote = quote;
        SeriesNumber = seriesNumber;
        Price = price;
        Image = image;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getQuote() {
        return Quote;
    }

    public void setQuote(String quote) {
        Quote = quote;
    }

    public int getSeriesNumber() {
        return SeriesNumber;
    }

    public void setSeriesNumber(int seriesNumber) {
        SeriesNumber = seriesNumber;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
