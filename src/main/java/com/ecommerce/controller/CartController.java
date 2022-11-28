package com.ecommerce.controller;


import com.ecommerce.dao.definition.CartDao;
import com.ecommerce.dao.definition.ProductDao;
import com.ecommerce.entity.CartItem;
import com.ecommerce.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @RequestMapping("/Cart")
    public String showCart(Model model, HttpSession httpSession){

        String userName= (String) httpSession.getAttribute("userName");
        List<CartItem> cartItemList = cartDao.listCartItems(userName);

        model.addAttribute("cartItemList",cartItemList);
        model.addAttribute("grandTotal", this.getGrandTotal(cartItemList));

        return "user/Cart";
    }
    @RequestMapping("/addToCart/{productId}")
    public String addToCart(Model model, @PathVariable("productId") int productId,
                            @RequestParam(value = "quantity",required = false) Long quantity,
                            HttpSession httpSession){

        Product product= productDao.getProduct(productId);
        String userName= (String) httpSession.getAttribute("userName");

        CartItem cartItem = new CartItem();
        cartItem.setProductId(product.getProductId());
        cartItem.setProductName(product.getProductName());
        cartItem.setQuantity(quantity);
        cartItem.setPrice(product.getProductPrice());
        cartItem.setPaymentStatus("NP");
        cartItem.setUserName(userName);

        cartDao.addCartItem(cartItem);

        List<CartItem> cartItemList= cartDao.listCartItems(userName);
        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("grandTotal", this.getGrandTotal(cartItemList));

        return "user/Cart";
    }

    @RequestMapping("updateCartItem/{cartItemId}")
    public String updateToCart(Model model, @PathVariable("cartItemId") int cartItemId,
                               @RequestParam("quantity") Long quantity, HttpSession httpSession){

        CartItem cartItem= cartDao.getCartItem(cartItemId);
        cartItem.setQuantity(quantity);
        cartDao.updateCartItem(cartItem);

        String userName= (String) httpSession.getAttribute("userName");
        List<CartItem> cartItemList = cartDao.listCartItems(userName);

        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("grandTotal", this.getGrandTotal(cartItemList));

        return "user/Cart";
    }

    @RequestMapping("/deleteCartItem/{cartItemId}")
    public String deleteCartItem(Model model, @PathVariable("cartItemId") int cartItemId, HttpSession httpSession){

        CartItem cartItem =cartDao.getCartItem(cartItemId);

        cartDao.deleteCartItem(cartItem);

        String userName=(String) httpSession.getAttribute("userName");
        List<CartItem> cartItemList = cartDao.listCartItems(userName);

        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("grandTotal", this.getGrandTotal(cartItemList));

        return "user/Cart";
    }


    public int getGrandTotal(List<CartItem> cartItem){

        int grandTotal=0, count=0;

        while (count<cartItem.size()){
            grandTotal= (int) (grandTotal+(cartItem.get(count).getQuantity() * cartItem.get(count).getPrice()));
            count++;
        }
        return grandTotal;
    }
}
