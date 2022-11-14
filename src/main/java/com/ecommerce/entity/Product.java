package com.ecommerce.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbproduct")
public class  Product implements Serializable {

    @Id
    @Column(name = "pro_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @Column(name = "pro_name")
    private String productName;

    @Column(name = "pro_desc")
    private String productDesc;

    @Column(name = "pro_price")
    private int productPrice;

    @Column(name = "stock")
    private int stock;

    @Column(name = "cat_id")
    private int categoryId;

    @Column(name = "sup_id")
    private int supplierId;
}
