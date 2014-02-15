package fr.icodem.eshop.model;

import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Product.class)
public class ProductFamily_ {

    public static volatile SingularAttribute<ProductFamily, Integer> id;
    public static volatile SingularAttribute<ProductFamily, String> name;
    public static volatile ListAttribute<ProductFamily, ProductFamily> subFamilies;

}
