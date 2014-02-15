package fr.icodem.eshop.model;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Product.class)
public class Product_ {

    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Double> price;
    public static volatile SingularAttribute<Product, Boolean> available;
    public static volatile SingularAttribute<Product, ProductImage> image;
    public static volatile SingularAttribute<Product, ProductFamily> family;

}
