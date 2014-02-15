package fr.icodem.eshop.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductFamilyDto {
    private int id;
    private String name;

    private List<ProductFamilyDto> subFamilies;

    public ProductFamilyDto() {}

    public ProductFamilyDto(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void addSubFamily(ProductFamilyDto subFamily) {
        if (subFamilies == null) subFamilies = new ArrayList<>();
        subFamilies.add(subFamily);
    }

    @Override
    public String toString() {
        return "ProductFamilyDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subFamilies=" + subFamilies +
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

    public List<ProductFamilyDto> getSubFamilies() {
        return subFamilies;
    }

    public void setSubFamilies(List<ProductFamilyDto> subFamilies) {
        this.subFamilies = subFamilies;
    }
}
