package com.serviceops.ecommerce.dto.user;

import com.serviceops.ecommerce.entities.Role;
import jakarta.validation.constraints.NotEmpty;


public class UserDto   {
    private  Long userId;
    private  String userFirstName;
    private  String userLastName;
    @NotEmpty
    private  String userEmail;
    @NotEmpty
    private String userPassword;
    @NotEmpty
    private  Role userRole;

    private String updatedBy;

    private String createdBy;

    public UserDto() {
    }

    public UserDto(Long userId, String userFirstName, String userLastName, String userEmail, String userPassword, Role userRole) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userRole = userRole;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Role getUserRole() {
        return userRole;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setUserRole(Role userRole) {
        this.userRole = userRole;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", userFirstName='" + userFirstName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRole=" + userRole +
                '}';
    }
}