package com.serviceops.ecommerce.dto.cart;


import jakarta.validation.constraints.NotNull;

public class AddToCartDto {

    private Integer id;
    private @NotNull long productId;
    private @NotNull Integer quantity;

    public AddToCartDto() {
    }

    public AddToCartDto(Integer id, Integer productId, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public @NotNull long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}

