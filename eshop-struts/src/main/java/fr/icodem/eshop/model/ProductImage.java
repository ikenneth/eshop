package fr.icodem.eshop.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.io.Serializable;

@Entity @Table(name = "product_image")
public class ProductImage implements Serializable {
    @Id
    private int id;

    @Lob
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
