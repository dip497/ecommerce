package com.serviceops.ecommerce.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Role {
    @JsonProperty("admin")
    ADMIN,
    @JsonProperty("customer")
    CUSTOMER
}
