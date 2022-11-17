package com.ecommerce.controller;


import com.ecommerce.dao.definition.CartDao;
import com.ecommerce.dao.definition.ProductDao;
import com.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CartController {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;
    
}
