package fr.icodem.eshop.service;

import fr.icodem.eshop.exception.OrderException;
import fr.icodem.eshop.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private SessionFactory sf;
    private SystemService systemService;

    // setters for injection
    public void setSf(SessionFactory sf) {
        this.sf = sf;
    }
    public void setSystemService(SystemService systemService) {
        this.systemService = systemService;
    }

    @Override
    public void createOrder(Cart cart, Customer customer) throws OrderException {
        // check cart is not empty
        if (cart.getItems() == null || cart.getItems().size() == 0) {
            throw new OrderException("Cart must not be empty to proceed checkout");
        }

        // get hibernate session
        Session session = sf.getCurrentSession();

        // build order from cart
        Order order = new Order();
        order.setDate(new Date());
        order.setCustomer(customer);
        order.setStatus(OrderStatus.Pending);

        for (CartItem item : cart.getItems()) {
            Product p = (Product) session.load(Product.class, item.getProduct().getId());
            order.addLine(p, item.getQuantity());
        }

        // generate order number
        String year = Integer.toString(Calendar.getInstance().get(Calendar.YEAR));
        String info = "Counter for order numbers for year " + year;
        int counter = systemService.getNextItemCounterValue("OrderNumber", year, info);
        String number =
                MessageFormat.format("CDE{0,date,yy}-{1,number,0000}",
                        Calendar.getInstance().getTime(), counter);
        order.setOrderNumber(number);

        // save order to database
        session.save(order);

        // mark cart as checked out
        cart.setCheckedOut(true);
    }

    @Override
    public List<Order> findOrderByCustomer(String username) {
        Session session = sf.getCurrentSession();
        String hql = "select distinct o from Order o " +
                "join fetch o.lines l join fetch l.product " +
                "where o.customer.username = :u";
        Query query = session.createQuery(hql);
        query.setParameter("u", username);
        List<Order> orders = query.list();
        return orders;
    }
}
