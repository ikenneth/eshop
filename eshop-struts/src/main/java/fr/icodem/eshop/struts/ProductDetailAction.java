package fr.icodem.eshop.struts;

import com.opensymphony.xwork2.ActionSupport;
import fr.icodem.eshop.model.Figure;
import fr.icodem.eshop.model.Product;
import fr.icodem.eshop.service.CatalogService;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Locale;

public class ProductDetailAction extends ActionSupport {

    private int productId;
    private Product product;

    private CatalogService service;

    // setter for injection
    public void setCatalogService(CatalogService service) {
        this.service = service;
    }

    @Override
    public String execute() throws Exception {
        product = service.findProduct(productId);
        return SUCCESS;
    }

    public String getLanguage(String code) {
        Locale locale = new Locale(code);
        String language = StringUtils.capitalize(locale.getDisplayLanguage());
        return language;
    }

    public String getLanguages(List<String> codes) {
        StringBuilder sb = new StringBuilder();
        for (String code : codes) {
            sb.append(getLanguage(code));
            sb.append(", ");
        }
        if (sb.length() > 2) sb.setLength(sb.length() - 2);
        return sb.toString();
    }

    public String getNames(List<Figure> figures) {
        StringBuilder sb = new StringBuilder();
        for (Figure figure : figures) {
            sb.append(figure.getName());
            sb.append(", ");
        }
        if (sb.length() > 2) sb.setLength(sb.length() - 2);
        return sb.toString();
    }

    // getters and setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
