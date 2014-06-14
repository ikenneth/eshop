package fr.icodem.eshop.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import fr.icodem.eshop.model.Product;
import fr.icodem.eshop.model.ProductFamily;
import fr.icodem.eshop.service.CatalogService;
import org.apache.struts2.interceptor.SessionAware;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public class ProductListAction extends ActionSupport
        implements Preparable, SessionAware {

    private int familyId;
    private String productType;// All, Book, Movie, Album
    private String keyword;
    private List<Product> products;
    private Map<String, Object> session;

    private CatalogService service;

    // setter for injection
    public void setCatalogService(CatalogService service) {
        this.service = service;
    }

    @Override
    public void prepare() throws Exception {
        familyId = -1;
    }


    @Override
    public String execute() throws Exception {
        if (productType == null && session.get("productType") == null) {
            productType = "Product";
        }
        else if (productType == null) {
            productType = (String) session.get("productType");
        }

        // save product type filter in session
        session.put("productType", productType);

        products = service.findProducts(familyId, productType, keyword);
        return SUCCESS;
    }

    public boolean isFamilyActive(ProductFamily f) {
        // if family is selected, ok
        if (f.getId() == this.familyId) return true;

        // if a sub-family of the family is selected, ok
        if (f.getSubFamilies() != null) {
            for (ProductFamily sf : f.getSubFamilies()) {
                if (sf.getId() == familyId) return true;
            }
        }

        // not active
        return false;
    }

    public String getDescription(String description) {
        final int maxLength = 200;
        String d = description;
        if (d != null && d.length() > maxLength) {
            d = d.substring(0, maxLength) + "...";
        }
        return d;
    }

    // getters and setters
    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
