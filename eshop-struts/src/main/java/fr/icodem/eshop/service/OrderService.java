package fr.icodem.eshop.service;

import fr.icodem.eshop.exception.OrderException;
import fr.icodem.eshop.model.Cart;
import fr.icodem.eshop.model.Customer;
import fr.icodem.eshop.model.Order;

import java.util.List;

public interface OrderService {
    void createOrder(Cart cart, Customer customer) throws OrderException;
    List<Order> findOrderByCustomer(String username);
}
