package com.serviceops.ecommerce.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="total_price")
    private long totalPrice;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "userId")
    private User user;

    @OneToMany(mappedBy="order",fetch = FetchType.LAZY)
    private List<OrderItem> orderItems;

    public Order(){}

    public Order(long totalPrice, User user, List<OrderItem> orderItems) {

        this.totalPrice = totalPrice;
        this.user = user;
        this.orderItems = orderItems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}
