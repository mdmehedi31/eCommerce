package com.ecommerce.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "tbproduct")
public class    Product implements Serializable {

    @Id
    @Column(name = "pro_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId;

    @Column(name = "pro_name")
    private String productName;

    @Column(name = "pro_desc")
    private String productDesc;

    @Column(name = "price")
    private Long productPrice;

    @Column(name = "stock")
    private int stock;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id",referencedColumnName = "cat_id")
    private Category category;

    @Column(name = "sup_id")
    private int supplierId;

   @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinColumn(name = "attachment_id", referencedColumnName = "id")
    private Attachment Attachment;
}
