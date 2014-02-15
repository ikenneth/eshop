package fr.icodem.eshop.model;

import javax.persistence.*;

@Entity @Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    protected int id;
    protected String name;
    protected String description;
    protected double price;
    protected boolean available;

    @OneToOne(fetch = FetchType.LAZY) @JoinColumn(name = "image_id")
    private ProductImage image;

    @ManyToOne @JoinColumn(name = "family_id")
    private ProductFamily family;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", family=" + family +
                ", image=" + image +
                '}';
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public ProductImage getImage() {
        return image;
    }

    public void setImage(ProductImage image) {
        this.image = image;
    }

    public ProductFamily getFamily() {
        return family;
    }

    public void setFamily(ProductFamily family) {
        this.family = family;
    }
}
