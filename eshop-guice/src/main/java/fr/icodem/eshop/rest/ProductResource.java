package fr.icodem.eshop.rest;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import fr.icodem.eshop.dto.ProductCriteriaDto;
import fr.icodem.eshop.dto.ProductDetailDto;
import fr.icodem.eshop.dto.ProductDto;
import fr.icodem.eshop.service.CatalogService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("product") @Singleton
public class ProductResource {

    @Inject
    private CatalogService service;

    @GET @Produces(MediaType.APPLICATION_JSON)
    public List<ProductDto> getProducts(@DefaultValue("") @QueryParam("keyword") String keyword,
                                        @DefaultValue("-1") @QueryParam("familyId") int familyId) {
        List<ProductDto> result =
                service.findProducts(new ProductCriteriaDto(keyword, familyId));

        return result;
    }

    @GET @Produces(MediaType.APPLICATION_JSON) @Path("{id}")
    public ProductDetailDto getProduct(@PathParam("id") int id) {
        ProductDetailDto p = service.findProductById(id);
        return p;
    }

}
