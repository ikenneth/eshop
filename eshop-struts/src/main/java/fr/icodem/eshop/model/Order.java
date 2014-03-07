package fr.icodem.eshop.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity @Table(name = "purchase_order")
public class Order implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "order_date") @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "tracking_number")
    private String trackingNumber;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @ManyToOne @JoinColumn(name = "customer_id")
    private Customer customer;

    // CascadeType.PERSIST is not sufficient => TransientObjectException
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    //@JoinColumn(name = "order_id") // if unidirectionnal one-to-many, then foreign key cannot be not null
    @OrderColumn(name = "position")
    private List<OrderLine> lines;

    public void addLine(Product p, int quantity) {
        OrderLine line = new OrderLine();
        line.setProduct(p);
        line.setQuantity(quantity);

        if (lines == null) {
            lines = new ArrayList<>();
        }
        lines.add(line);
        line.setOrder(this);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", orderNumber='" + orderNumber + '\'' +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", status=" + status +
                ", customer=" + customer +
                '}';
    }

    // getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderLine> getLines() {
        return lines;
    }

    public void setLines(List<OrderLine> lines) {
        this.lines = lines;
    }
}
