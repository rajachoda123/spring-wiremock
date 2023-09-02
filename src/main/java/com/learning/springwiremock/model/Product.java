package com.learning.springwiremock.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    Long productId;

    @Column(name = "name")
    String productName;
}
