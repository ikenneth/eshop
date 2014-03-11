package fr.icodem.eshop.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ItemCounterId implements Serializable {
    private String item;
    private String subset;

    public ItemCounterId() {}

    public ItemCounterId(String item, String subset) {
        this.item = item;
        this.subset = subset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemCounterId that = (ItemCounterId) o;

        if (item != null ? !item.equals(that.item) : that.item != null) return false;
        if (subset != null ? !subset.equals(that.subset) : that.subset != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = item != null ? item.hashCode() : 0;
        result = 31 * result + (subset != null ? subset.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ItemCounterId{" +
                "item='" + item + '\'' +
                ", subset='" + subset + '\'' +
                '}';
    }

    // getters and setters
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getSubset() {
        return subset;
    }

    public void setSubset(String subset) {
        this.subset = subset;
    }
}
