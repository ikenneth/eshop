package fr.icodem.eshop.service;

import fr.icodem.eshop.exception.OrderException;
import fr.icodem.eshop.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service @Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private SessionFactory sf;

    @Autowired
    private SystemService systemService;

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
            //TODO replace with load ==> pb with proxy javassist
            Product p = (Product) session.get(Product.class, item.getProduct().getId());
            order.addLine(p, item.getQuantity());
        }

        // generate order number
        int counter = systemService.getNextItemCounterValue("Order", "");
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
        String hql = "select o from Order o join fetch o.lines where o.customer.username = :u";
        Query query = session.createQuery(hql);
        query.setParameter("u", username);
        List<Order> orders = query.list();
        return orders;
    }
}
