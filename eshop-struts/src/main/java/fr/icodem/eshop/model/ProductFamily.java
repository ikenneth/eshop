package fr.icodem.eshop.model;

import java.io.Serializable;
import java.util.List;

public class ProductFamily implements Serializable {
    private int id;
    private String name;

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
