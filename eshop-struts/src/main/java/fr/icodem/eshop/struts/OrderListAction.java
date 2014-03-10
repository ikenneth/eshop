package fr.icodem.eshop.struts;

import com.opensymphony.xwork2.ActionSupport;
import fr.icodem.eshop.model.Customer;
import fr.icodem.eshop.model.Order;
import fr.icodem.eshop.service.OrderService;
import org.apache.struts2.interceptor.SessionAware;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

public class OrderListAction extends ActionSupport implements SessionAware {

    @Resource
    private OrderService service;

    private Map<String, Object> session;

    private List<Order> orders;

    @Override
    public String execute() throws Exception {
        Customer c = (Customer) session.get("user");
        if (c == null) {
            addActionError(getText("login-required"));
        }
        else {
            orders = service.findOrderByCustomer(c.getUsername());
        }

        return SUCCESS;
    }

    // getters and setters
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

}
