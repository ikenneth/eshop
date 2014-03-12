package fr.icodem.eshop.struts;

import java.io.Serializable;

public class BreadcrumbItem implements Serializable {
    private String action;
    private String key;// i18n

    public BreadcrumbItem(String action, String key) {
        this.action = action;
        this.key = key;
    }

    @Override
    public String toString() {
        return "BreadcrumbItem{" +
                "action='" + action + '\'' +
                ", key='" + key + '\'' +
                '}';
    }

    // getters and setters
    public String getAction() {
        return action;
    }

    public String getKey() {
        return key;
    }
}
