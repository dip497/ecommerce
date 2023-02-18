package com.serviceops.ecommerce.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Cart {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;


    @OneToMany(mappedBy = "orderProductId",fetch = FetchType.LAZY)
    private List<OrderProduct> orderProduct = new ArrayList<>();


    @OneToOne
    private  User user;
    public Cart(List<OrderProduct> orderProduct,User user) {
        this.orderProduct = orderProduct;
        this.user = user;
    }

    public Cart() {
    }


    @Override
    public String toString() {
        return "Cart{" +
                "cartId=" + cartId +
                ", orderProduct=" + orderProduct +
                ", user=" + user +
                '}';
    }
}


