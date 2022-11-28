package com.ecommerce.controller;


import com.ecommerce.dao.definition.CategoryDao;
import com.ecommerce.dto.CategoryDto;
import com.ecommerce.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
public class CategoryController {
    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping("category")
    public String category(Model m){
        m.addAttribute("categoryDto", new CategoryDto());
       return "admin/category";
    }


     @PostMapping( "views/category")
     public String createCategory(Model model,
                                  @ModelAttribute("categoryDto") CategoryDto categoryDto
                                  ) throws IOException {

        Category category = new Category();

         category.setCategoryName(categoryDto.getCategoryName());
         category.setCategoryDesc(categoryDto.getCategoryDesc());

         categoryDao.addCategory(category);

         model.addAttribute("category",category);

          return "redirect:/showCategory";
     }

     @GetMapping("/showCategory")
     public String getCategory(Model model){

        List<Category> categories= categoryDao.listCategory();
        model.addAttribute("categories",categories);
        return "admin/showCategory";
     }

     @RequestMapping(value = "/updateCategory", method = RequestMethod.POST)
     public String updateCategory(Model model,  @RequestParam("categoryId")
                                    int categoryId,
                                  @ModelAttribute("categoryDto") CategoryDto
                                          categoryDto){


            Category category= categoryDao.getCategory(categoryId);
            category.setCategoryName(categoryDto.getCategoryName());
            category.setCategoryDesc(categoryDto.getCategoryDesc());
            categoryDao.updateCategory(category);
            /*
            List<Category> listCategory= categoryDao.listCategory();
            model.addAttribute("listCategory",listCategory);
             model.addAttribute("category",category);

             */
        return "redirect:/showCategory";
     }

     @RequestMapping(value ="/editCategory/{categoryId}")
     public String editCategory(Model model,
                                  @PathVariable("categoryId")
                                  int categoryId){
        Category category= categoryDao.getCategory(categoryId);
        model.addAttribute("category",category);
         return "admin/updateCategory";
     }

     @RequestMapping(value = "/deleteCategory/{catId}")
     public String deleteCategory(Model m,
                                  @PathVariable("catId")int categoryId){

        Category category=categoryDao.getCategory(categoryId);
        categoryDao.deleteCategory(category);

         /*List<Category> categories= categoryDao.listCategory();
         m.addAttribute("categories",categories);*/
         return "redirect:/showCategory";
     }

}
