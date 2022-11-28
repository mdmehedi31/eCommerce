package com.ecommerce.dto;

import com.ecommerce.entity.Category;
import lombok.Data;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Data
public class ProductDto {

    private String productName;
    private String productDesc;
    private int productPrice;
    private int stock;
    private String category;
    private int supplierId;
}
