package com.ecommerce.controller;


import com.ecommerce.dao.definition.ProductDao;
import com.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private ProductDao productDao;

    @RequestMapping(value = "/userHome")
    public String showUserHome(Model model, HttpSession httpSession){

        List<Product> listProduct= productDao.listProduct();
        model.addAttribute("productList",listProduct);
        return "userHome";
    }

}
