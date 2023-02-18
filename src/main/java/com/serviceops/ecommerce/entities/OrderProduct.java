package com.serviceops.ecommerce.entities;

import jakarta.persistence.*;



@Entity
public class OrderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderProductId;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "product_product_id")
    private Product product;


    @Column(name = "quantity")
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public OrderProduct() {
    }

    public OrderProduct(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getOrderProductId() {
        return orderProductId;
    }

    public void setOrderProductId(Long orderProductId) {
        this.orderProductId = orderProductId;
    }

    @Override
    public String toString() {
        return "OrderProduct{" +
                "orderProductId=" + orderProductId +
                ", quantity=" + quantity +
                '}';
    }
}
