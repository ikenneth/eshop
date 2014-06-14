package fr.icodem.eshop.model;

public class ItemCounter {
    private ItemCounterId id;

    private String info;
    private int nextValue;

    public void increment() {
        nextValue++;
    }

    @Override
    public String toString() {
        return "ItemCounter{" +
                "id=" + id +
                ", info='" + info + '\'' +
                ", nextValue=" + nextValue +
                '}';
    }

    // getters and setters
    public ItemCounterId getId() {
        return id;
    }

    public void setId(ItemCounterId id) {
        this.id = id;
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
