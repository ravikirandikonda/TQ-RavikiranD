package com.example.demo.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "content_offering_id")
    private ContentOffering contentOffering;

    private int quantity;

    public Cart() {
    }

    public Cart(ContentOffering contentOffering, int quantity) {
        this.contentOffering = contentOffering;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContentOffering getContentOffering() {
        return contentOffering;
    }

    public void setContentOffering(ContentOffering contentOffering) {
        this.contentOffering = contentOffering;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return contentOffering.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}
