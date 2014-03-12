package fr.icodem.eshop.struts;

import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class BreadcrumbStack implements Serializable {
    private Deque<BreadcrumbItem> items = new ArrayDeque<>();

    public void addItem(String action, String key) {
        BreadcrumbItem item = new BreadcrumbItem(action, key);
        items.add(item);
    }

    public Iterator<BreadcrumbItem> iterator() {
        return items.iterator();
    }

    public void clearAndKeepFirst() {
        BreadcrumbItem item = items.removeFirst();
        items.clear();
        items.add(item);
    }

    public boolean isLast(String action) {
        BreadcrumbItem item = items.getLast();
        return action.equals(item.getAction());
    }

}
