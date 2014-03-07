package fr.icodem.eshop.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name = "item_counter")
public class ItemCounter {
    @Id
    private String item;

    private String info;

    @Column(name = "next_value")
    private int nextValue;

    public void increment() {
        nextValue++;
    }

    @Override
    public String toString() {
        return "ItemCounter{" +
                "item='" + item + '\'' +
                ", info='" + info + '\'' +
                ", nextValue=" + nextValue +
                '}';
    }

    // getters and setters
    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getNextValue() {
        return nextValue;
    }

    public void setNextValue(int nextValue) {
        this.nextValue = nextValue;
    }
}
