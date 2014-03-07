package fr.icodem.eshop.struts;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import fr.icodem.eshop.model.Cart;
import fr.icodem.eshop.model.Customer;
import fr.icodem.eshop.model.Product;
import fr.icodem.eshop.service.CatalogService;
import fr.icodem.eshop.service.OrderService;
import org.apache.struts2.interceptor.SessionAware;

import javax.annotation.Resource;
import java.util.Map;

public class CartAction extends ActionSupport implements SessionAware, Preparable {

    @Resource
    private CatalogService catalogService;

    @Resource
    private OrderService orderService;

    private Map<String, Object> session;

    private String from;
    private int productId;
    private int quantity;

    // if add item is done from product list
    private String keyword;
    private int familyId;

    private Cart cart;

    @Override
    public void prepare() throws Exception {
        cart = (Cart) session.get("cart");

        if (!cart.isEmpty() && session.get("user") == null) {
            addActionMessage("Vous devez vous connecter pour passer la commande");
        }
    }

    public String addItem() throws Exception {
        Product p = catalogService.findProduct(productId);
        cart.addItem(p, quantity);

        return from;
    }

    public String removeItem() throws Exception {
        cart.remove(productId);
        return SUCCESS;
    }

    public String checkout() throws Exception {
        try {
            Customer customer = (Customer) session.get("user");
            orderService.createOrder(cart, customer);

            session.remove("cart");
            addActionMessage("Your order has been successfully saved");

            session.put("cart", new Cart());// otherwise, cart is not properly displayed in header
            return SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            addActionError("An error occured while saving your order");
            return SUCCESS;
        }
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

    public Cart getCart() {
        return cart;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}
