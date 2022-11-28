package com.ecommerce.dao.definition;

import com.ecommerce.entity.Product;

import java.util.List;

public interface ProductDao {

    public boolean addProduct(Product product);
    public boolean deleteProduct(Product product);
    public boolean updateProduct(Product product);

    public List<Product> listProduct();
    public Product getProduct(int productId);

    /*public String getCategoryByProductId(int productId);*/
}
