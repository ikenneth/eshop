package fr.icodem.eshop.struts;

import com.opensymphony.xwork2.ActionSupport;
import fr.icodem.eshop.model.Product;
import fr.icodem.eshop.service.CatalogService;
import org.apache.struts2.interceptor.SessionAware;

import javax.annotation.Resource;
import java.util.Map;

public class CartAction extends ActionSupport implements SessionAware {

    @Resource
    private CatalogService service;

    private Map<String, Object> session;

    private String from;
    private int productId;
    private int quantity;

    // if add item is done from product list
    private String keyword;
    private int familyId;

    public String addItem() throws Exception {
        Product p = service.findProduct(productId);

        Cart cart = (Cart) session.get("cart");
        cart.addItem(p, quantity);

        return from;
    }

    public String removeItem() throws Exception {
        Cart cart = (Cart) session.get("cart");
        cart.remove(productId);
        return SUCCESS;
    }

    // getters and setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getFamilyId() {
        return familyId;
    }

    public void setFamilyId(int familyId) {
        this.familyId = familyId;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
