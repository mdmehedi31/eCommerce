package com.ecommerce.dao.definition;

import com.ecommerce.entity.Category;

import java.util.List;

public interface CategoryDao {

    public boolean addCategory(Category category);
    public boolean deleteCategory(Category category);
    public boolean updateCategory(Category category);

    public List<Category> listCategory();
    public Category getCategory(int categoryId);
    public Category getByName(String name);

}
