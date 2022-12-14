package com.ecommerce.controller;


import com.ecommerce.config.Properties;
import com.ecommerce.dao.definition.AttachmentDao;
import com.ecommerce.dao.definition.CategoryDao;
import com.ecommerce.dao.definition.ProductDao;
import com.ecommerce.dto.ProductDto;
import com.ecommerce.entity.Attachment;
import com.ecommerce.entity.Category;
import com.ecommerce.entity.Product;
import com.ecommerce.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private AttachmentDao attachmentDao;

    @GetMapping("/createProduct")
    public ModelAndView product(Model model){

        List<Category> categories= categoryDao.listCategory();
        List<String> categoryList = new ArrayList<>();

        for (Category  category : categories){
            categoryList.add(category.getCategoryName());
        }
        model.addAttribute("categoryList",categoryList);
        model.addAttribute("product", new Product());

        return new ModelAndView("/admin/createProduct","model", model);
    }


    @PostMapping("views/createProduct")
    public String store(Model model, @ModelAttribute("product") ProductDto productDto,
                        @RequestParam("image") MultipartFile file) throws IOException {

        Category category=categoryDao.getByName(productDto.getCategory());
        Attachment attachment=Utils.saveFile(file,Properties.USER_FOLDER);

       /* String name=category.getCategoryName();*/

        Product product= new Product();
        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        product.setStock(productDto.getStock());
        product.setCategory(category);
        product.setSupplierId(productDto.getSupplierId());
        product.setProductDesc(productDto.getProductDesc());
        product.setAttachment(attachment);
        productDao.addProduct(product);

/*        model.addAttribute("name", name);*/
      //  model.addAttribute("products", product);
        return "redirect:/showProduct";
    }

    @GetMapping("/showProduct")
    public String showProduct(Model model){

        List<Product> products= productDao.listProduct();
        model.addAttribute("products",products);
        return "/user/showProduct";
    }

    @RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
    public String updateProduct(Model model, @RequestParam("productId") int productId,
                                @ModelAttribute("productDto") ProductDto productDto){

        Product product= productDao.getProduct(productId);
        product.setProductName(productDto.getProductName());
        product.setProductPrice(productDto.getProductPrice());
        product.setStock(productDto.getStock());
        product.setSupplierId(productDto.getSupplierId());

        productDao.updateProduct(product);

        return "redirect:/user/showProduct";
    }

    @RequestMapping(value = "/editProduct/{productId}")
    public String editProduct(Model model,
                              @PathVariable("productId") int productId){

        Product product = productDao.getProduct(productId);
        model.addAttribute("product", product);

        return "/updateProduct/updateProduct";
    }

    @RequestMapping(value = "/deleteProduct/{productId}")
    public String deleteProduct(Model model, @PathVariable("productId") int productId){

        Product product=productDao.getProduct(productId);
        productDao.deleteProduct(product);

        return "redirect:/showProduct/showProduct";
    }

    @RequestMapping(value = "/productDisplay")
    public String displayAllProduct(Model model){
        List<Product> productList= productDao.listProduct();
        model.addAttribute("productList", productList);
        return "/user/productDisplay";
    }

    @RequestMapping(value = "/totalProductDisplay/{productId}")
    public String totalProductDisplay(Model model,
                                      @PathVariable("productId")
    int productId){

        Product product= productDao.getProduct(productId);
        model.addAttribute("product",product);
        return "user/totalProductDisplay";

    }

}
