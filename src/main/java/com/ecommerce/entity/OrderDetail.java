package com.ecommerce.entity;

import lombok.Data;
import org.hibernate.annotations.CollectionId;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "tbOrderDetails")
public class OrderDetail {

    @Id
    @Column(name = "ord_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @Column(name = "cart_id")
    private int cartId;
    @Column(name = "total_amount")
    private int totalAmount;
    @Column(name = "user_name")
    private String userName;
    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "shipp_add")
    private String shippingAddress;
    @Column(name = "trans")
    private String trans;
}
