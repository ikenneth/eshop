package fr.icodem.eshop.service;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;
import fr.icodem.eshop.dto.*;
import fr.icodem.eshop.model.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
public class CatalogService {

    @Inject
    private Provider<EntityManager> entityManagerProvider;

    public List<ProductDto> findProducts(ProductCriteriaDto pCriteria) {

        String keyword = pCriteria.getKeyword();
        int familyId = pCriteria.getFamilyId();

        EntityManager em = entityManagerProvider.get();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
        Root<Product> root = criteria.from(Product.class);
        criteria.select(root);

        if (keyword != null && !"".equals(keyword.trim())) {
            criteria.where(builder.like(root.get(Product_.name), '%' + keyword + '%'));
        }
        if (familyId != -1) {
            List<ProductFamily> inFamilies = new ArrayList<>();
            ProductFamily family = em.getReference(ProductFamily.class, familyId);
            inFamilies.add(family);
            inFamilies.addAll(family.getSubFamilies());
            //Predicate prdFam = builder.equal(root.get(Product_.family), family);

            Predicate prdFam = root.get(Product_.family).in(inFamilies);

            //root.get(Product_.family).
            //Predicate prdSubFam = builder.in(builder.);
            //Predicate prdFam = builder.in(root.get(Product_.family), family);
//            Predicate prdSubFam = builder.isMember(root.get(Product_.family),
//                    root.get(Product_.family).get(ProductFamily_.subFamilies));
            criteria.where(prdFam);
            //criteria.where(builder.or(prdFam, prdSubFam));
        }

        //Query query = em.createQuery("select p from Product p");
        Query query = em.createQuery(criteria);
        //query.setMaxResults(10);

        List<ProductDto> result = new ArrayList<>();
        List<Product> products = query.getResultList();
        for (Product p : products) {
            result.add(new ProductDto(p.getId(), p.getName()));
        }

            /*
        if (familyId == -1 && (keyword == null || "".equals(keyword.trim()))) {
            result.add(new ProductDto(1, "Tintin au Tibet"));
            result.add(new ProductDto(2, "Astérix le Gaulois"));
        } else if (familyId != -1) {
            result.add(new ProductDto(1, "Tintin au Tibet (" + familyId + ")"));
            result.add(new ProductDto(2, "Astérix le Gaulois (" + familyId + ")"));
        } else if ((keyword != null && !"".equals(keyword.trim()))) {
            result.add(new ProductDto(1, "Tintin au Tibet (" + keyword + ")"));
            result.add(new ProductDto(2, "Astérix le Gaulois (" + keyword + ")"));
        }     */

        return result;
    }

    public ProductDetailDto findProductById(int id) {
        EntityManager em = entityManagerProvider.get();
        Product p = em.find(Product.class, id);

        ProductDetailDto result = new ProductDetailDto();
        result.setId(p.getId());
        result.setName(p.getName());
        result.setDescription(p.getDescription());
        result.setPrice(p.getPrice());

        if (p instanceof Book) {
            Book b = (Book)p;
            result.setType(ProductType.Book);
            result.setReleaseDate(b.getReleaseDate());
            result.setIsbn(b.getIsbn());
            result.setLanguage(b.getLanguage());
            result.setPages(b.getPages());
            for (Figure author : b.getAuthors()) {
                result.addAuthor(new FigureDto(author.getId(), author.getName()));
            }
        }
        else if (p instanceof Movie) {
            Movie m = (Movie)p;
            result.setType(ProductType.Movie);
            result.setReleaseDate(m.getReleaseDate());
            result.setLength(m.getLength());
            for (Figure actor : m.getActors()) {
                result.addActor(new FigureDto(actor.getId(), actor.getName()));
            }
            if (m.getDirector() != null) {
                result.setDirector(new FigureDto(m.getDirector().getId(), m.getDirector().getName()));
            }
            if (m.getLanguages().size() > 0) {
                result.setLanguages(m.getLanguages().toArray(new String[m.getLanguages().size()]));
            }
        }
        else if (p instanceof Album) {
            Album a = (Album)p;
            result.setType(ProductType.Album);
            result.setReleaseDate(a.getReleaseDate());
            result.setLength(a.getLength());
            for (Figure artist : a.getArtists()) {
                result.addArtist(new FigureDto(artist.getId(), artist.getName()));
            }
        }

        return result;
    }

    public byte[] findProductImage(int productId) {
        EntityManager em = entityManagerProvider.get();
        String jpql = "select p.image from Product p where p.id = :productId";
        //Product p = em.find(Product.class, productId);
        Query query = em.createQuery(jpql);
        query.setParameter("productId", productId);
        ProductImage image = (ProductImage) query.getSingleResult();
        byte[] content = null;
        if (image != null) {
            //image = p.getImage().getContent();
            content = image.getContent();
        }
        return content;
    }

    public List<ProductFamilyDto> findProductFamilies() {
        EntityManager em = entityManagerProvider.get();
        String jpql = "select f from ProductFamily f " +
                      "where f not in (select elements(parent.subFamilies) from ProductFamily parent)";
        Query query = em.createQuery(jpql);
        List<ProductFamily> families = query.getResultList();

        List<ProductFamilyDto> result = new ArrayList<>();
        for (ProductFamily f : families) {
            ProductFamilyDto dto = new ProductFamilyDto(f.getId(), f.getName());
            for (ProductFamily sf : f.getSubFamilies()) {
                dto.addSubFamily(new ProductFamilyDto(sf.getId(), sf.getName()));
            }
            result.add(dto);
        }

        return result;
    }
}
