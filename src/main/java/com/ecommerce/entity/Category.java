package com.ecommerce.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "tbcategory")
public class Category implements Serializable {

    @Id
    @Column(name = "cat_id",  nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int categoryId;

    @Column(name = "cat_name")
    private String categoryName;

    @Column(name = "cat_desc")
    private String categoryDesc;
}
