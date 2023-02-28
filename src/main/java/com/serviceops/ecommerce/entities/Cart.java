package com.serviceops.ecommerce.entities;

import com.serviceops.ecommerce.dto.Product.ProductDto;
import jakarta.persistence.*;


@Entity
public class Cart {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "productId")
    private Product product;

    @OneToOne
    private  User user;

    private int quantity;

    public Cart() {


    }

    public Cart( Product product, User user, int quantity) {
        this.product = product;
        this.user = user;
        this.quantity = quantity;
    }


    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}


