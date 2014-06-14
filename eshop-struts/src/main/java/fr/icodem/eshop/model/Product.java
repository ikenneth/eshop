package fr.icodem.eshop.model;

import java.io.Serializable;

public class Product implements Serializable {
    protected int id;
    protected String name;
    protected String description;
    protected double price;

    protected ProductFamily family;

    protected ProductImage image;

    // getters and setters
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

    public ProductFamily getFamily() {
        return family;
    }

    public void setFamily(ProductFamily family) {
        this.family = family;
    }

    public ProductImage getImage() {
        return image;
    }

    public void setImage(ProductImage image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
