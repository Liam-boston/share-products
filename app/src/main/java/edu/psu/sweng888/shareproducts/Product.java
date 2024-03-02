package edu.psu.sweng888.shareproducts;

import java.io.Serializable;

public class Product implements Serializable {
    private String name;
    private String description;
    private String seller;
    private Integer price;

    public Product(String name, String description, String seller, Integer price) {
        this.name = name;
        this.description = description;
        this.seller = seller;
        this.price = price;
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

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String toString() {
        return ("Product: " + this.name + " | Description: " + this.description + " | Sold by: " + this.seller + " | Price: $" + this.price + ".00");
    }
}
