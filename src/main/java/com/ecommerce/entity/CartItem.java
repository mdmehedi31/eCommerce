package com.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbcartitem")
public class CartItem  implements Serializable {

    @Id
    @Column(name = "cart_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int cartItemId;

    @Column(name = "prod_id")
    private int productId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private Long price;

    @Column(name = "productName")
    private String productName;

    @Column(name = "userName")
    private String userName;

    @Column(name = "paymentStatus")
    private String paymentStatus;
}
