package com.serviceops.ecommerce.entities;

import jakarta.persistence.*;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    private String user_name;
    private String user_email;
    private String user_password;
    @Enumerated(EnumType.STRING)
    private Role user_role;

    protected User() {
    }

    public User(String user_name, String user_email, String user_password, Role user_role) {
        this.user_name = user_name;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_role = user_role;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Role getUser_role() {
        return user_role;
    }

    public void setUser_role(Role user_role) {
        this.user_role = user_role;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_role=" + user_role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getUser_id() != null ? !getUser_id().equals(user.getUser_id()) : user.getUser_id() != null) return false;
        if (getUser_name() != null ? !getUser_name().equals(user.getUser_name()) : user.getUser_name() != null)
            return false;
        if (getUser_email() != null ? !getUser_email().equals(user.getUser_email()) : user.getUser_email() != null)
            return false;
        if (getUser_password() != null ? !getUser_password().equals(user.getUser_password()) : user.getUser_password() != null)
            return false;
        return getUser_role() == user.getUser_role();
    }

    @Override
    public int hashCode() {
        int result = getUser_id() != null ? getUser_id().hashCode() : 0;
        result = 31 * result + (getUser_name() != null ? getUser_name().hashCode() : 0);
        result = 31 * result + (getUser_email() != null ? getUser_email().hashCode() : 0);
        result = 31 * result + (getUser_password() != null ? getUser_password().hashCode() : 0);
        result = 31 * result + (getUser_role() != null ? getUser_role().hashCode() : 0);
        return result;
    }
}
