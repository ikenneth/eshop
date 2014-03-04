package fr.icodem.eshop.struts;

import fr.icodem.eshop.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
    private List<CartItem> items;
    private double totalPrice;
    private int totalQuantity;

    public void addItem(Product p, int quantity) {
        if (items == null) items = new ArrayList<>();
        for (Iterator<CartItem> it = items.iterator(); it.hasNext();) {
            CartItem item = it.next();
            if (item.getProduct().getId() == p.getId()) {
                item.setQuantity(quantity);
                updateTotals();
                return;
            }
        }

        // not found, add new item
        items.add(new CartItem(p, quantity));
        updateTotals();
    }

    public void remove(int productId) {
        if (items != null) {
            for (Iterator<CartItem> it = items.iterator(); it.hasNext();) {
                CartItem item = it.next();
                if (item.getProduct().getId() == productId) {
                    it.remove();
                    updateTotals();
                    break;
                }
            }
        }
    }

    public void clear() {
        if (items != null) items.clear();
        updateTotals();
    }

    private void updateTotals() {
        totalPrice = 0;
        totalQuantity = 0;
        if (items != null) {
            for (CartItem item : items) {
                totalPrice += item.getProduct().getPrice() * item.getQuantity();
                totalQuantity += item.getQuantity();
            }
        }
    }

    // getters and setters
    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
