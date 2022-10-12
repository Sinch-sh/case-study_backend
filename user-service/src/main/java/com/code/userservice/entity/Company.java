package com.code.userservice.entity;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Collection;

@AllArgsConstructor
@Document(collection="company")
public class Company {

    @Id
    private String id;

    private String name;

    private String email;

    private String location;

    private String username;
    public String product_category;
    @Field
    public Collection<Coupon> coupon;

    private String password;
    private boolean deleted=Boolean.FALSE;



    @DBRef
    private Role role;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProduct_category() {
        return product_category;
    }

    public void setProduct_category(String product_category) {
        this.product_category = product_category;
    }

    public Collection<Coupon> getCoupon() {
        return coupon;
    }

    public void setCoupon(Collection<Coupon> coupon) {
        this.coupon = coupon;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    //constructor
    public Company() {
    }

    public Company(String id, String name, String email, String username, String location, String password, String product_category, Collection<Coupon> coupon) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.location = location;
        this.password = password;
        this.product_category=product_category;
        this.coupon = coupon;

    }
}
