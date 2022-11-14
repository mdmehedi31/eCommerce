package com.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbsupplier")
public class Supplier implements Serializable {

    @Id
    @Column(name = "sup_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int supplierId;

    @Column(name = "sup_name")
    private String supplierName;

    @Column(name = "sup_address")
    private String supplierAddress;
}
