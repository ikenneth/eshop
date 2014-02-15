package fr.icodem.eshop.rest;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import fr.icodem.eshop.dto.ProductFamilyDto;
import fr.icodem.eshop.service.CatalogService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("family") @Singleton
public class ProductFamilyResource {

    @Inject
    private CatalogService service;

    @GET @Produces(MediaType.APPLICATION_JSON)
    public List<ProductFamilyDto> getProducts() {
        /*
        ProductFamilyDto fam1 = new ProductFamilyDto(1, "Littérature");
        fam1.addSubFamily(new ProductFamilyDto(2, "Roman"));
        fam1.addSubFamily(new ProductFamilyDto(3, "Roman historique"));
        fam1.addSubFamily(new ProductFamilyDto(4, "Roman policier"));

        ProductFamilyDto fam2 = new ProductFamilyDto(5, "BD");
        fam2.addSubFamily(new ProductFamilyDto(6, "Manga"));

        ProductFamilyDto fam3 = new ProductFamilyDto(9, "Comédies, aventure");
        fam3.addSubFamily(new ProductFamilyDto(10, "Western"));
        fam3.addSubFamily(new ProductFamilyDto(11, "Film historique"));
        fam3.addSubFamily(new ProductFamilyDto(12, "Policier"));

        List<ProductFamilyDto> result = new ArrayList<>();
        result.add(fam1);
        result.add(fam2);
        result.add(fam3);
        */
        List<ProductFamilyDto> result = service.findProductFamilies();

        return result;
    }
}
