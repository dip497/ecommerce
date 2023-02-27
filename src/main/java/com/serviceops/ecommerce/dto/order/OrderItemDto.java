package com.serviceops.ecommerce.dto.order;

import com.serviceops.ecommerce.dto.Product.ProductDto;




public class OrderItemDto {
    private  Integer id;
    private  ProductDto productDto;
    private  OrderDto orderDto;
    private  int quantity;
    private  long price;

    public OrderItemDto(Integer id, ProductDto product, OrderDto orderDto, int quantity, long price) {
        this.id = id;
        this.productDto = product;
        this.orderDto = orderDto;
        this.quantity = quantity;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public ProductDto getProduct() {
        return productDto;
    }

    public OrderDto getOrder() {
        return orderDto;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getPrice() {
        return price;
    }
}