package fr.icodem.eshop.service;

import fr.icodem.eshop.model.*;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class CatalogServiceImpl implements CatalogService {

    private SessionFactory sf;

    // setter for injection
    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<ProductFamily> findFamilies() {
        Session session = sf.getCurrentSession();
        String hql = "select distinct f from ProductFamily f left join fetch f.subFamilies " +
                "where f not in (select elements(pf.subFamilies) from ProductFamily pf)";
        Query query = session.createQuery(hql);
        List<ProductFamily> families = query.list();

        return families;
    }

    @Override
    public List<Product> findProducts(int familyId, String productType, String keyword) {
        Session session = sf.getCurrentSession();
        String hql = "select p from " +  productType + " p where 1=1";
        if (familyId != -1) {
            hql += " and (p.family.id = :familyId or p.family in " +
                    "(select elements(f.subFamilies) from ProductFamily f where f.id = :familyId))";
        }
        if (keyword != null && keyword.trim().length() > 0) {
            hql += " and p.name like :keyword";
        }

        Query query = session.createQuery(hql);
        query.setMaxResults(30);
        if (familyId != -1) {
            query.setParameter("familyId", familyId);
        }
        if (keyword != null && keyword.trim().length() > 0) {
            keyword = "%" + keyword.trim() + "%";
            query.setParameter("keyword", keyword);
        }

        List<Product> products = query.list();

        return products;
    }

    @Override
    public Product findProduct(int productId) {
        Session session = sf.getCurrentSession();
        Product p = (Product) session.get(Product.class, productId);

        if (p instanceof Book) {
            Book b = (Book)p;
            Hibernate.initialize(b.getAuthors());
        }
        if (p instanceof Movie) {
            Movie m = (Movie)p;
            Hibernate.initialize(m.getLanguages());
            Hibernate.initialize(m.getActors());
        }
        if (p instanceof Album) {
            Album a = (Album)p;
            Hibernate.initialize(a.getArtists());
        }
        return p;
    }

    @Override
    public ProductImage findProductImage(int imageId) {
        Session session = sf.getCurrentSession();
        ProductImage image = (ProductImage) session.get(ProductImage.class, imageId);
        return image;
    }
}
