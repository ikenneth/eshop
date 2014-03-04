package fr.icodem.eshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity @Table(name = "product_family")
public class ProductFamily implements Serializable {
    @Id
    private int id;
    private String name;

    @OneToMany @JoinColumn(name = "parent_id")
    private List<ProductFamily> subFamilies;

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

    public List<ProductFamily> getSubFamilies() {
        return subFamilies;
    }

    public void setSubFamilies(List<ProductFamily> subFamilies) {
        this.subFamilies = subFamilies;
    }
}
