package fr.icodem.eshop.model;

import java.io.Serializable;

public class ProductImage implements Serializable {
    private int id;

    private byte[] content;

    @Override
    public String toString() {
        return "ProductImage{" +
                "id=" + id +
                '}';
    }

    // getter and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
