package com.hibernate.relations.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="address")
public class Address implements Serializable {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String addressType;
   private String address;
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "customer_id")
   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   private Customer customer;

    public Address() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
