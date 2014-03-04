package fr.icodem.eshop.service;

import fr.icodem.eshop.model.Product;
import fr.icodem.eshop.model.ProductFamily;
import fr.icodem.eshop.model.ProductImage;

import java.util.List;

public interface CatalogService {
    List<ProductFamily> findFamilies();

    List<Product> findProducts(int familyId, String productType, String keyword);

    Product findProduct(int productId);

    ProductImage findProductImage(int imageId);
}
