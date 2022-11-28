package com.ecommerce.controller;

import com.ecommerce.dao.definition.CartDao;
import com.ecommerce.dao.definition.OrderDao;
import com.ecommerce.dao.definition.ProductDao;
import com.ecommerce.dao.definition.UserDao;
import com.ecommerce.entity.CartItem;
import com.ecommerce.entity.OrderDetail;
import com.ecommerce.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PaymentController {

    @Autowired
    private CartDao cartDao;

    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao  userDao;

    @Autowired
    private OrderDao orderDao;

    @RequestMapping("/checkout")
    public String checkOut(Model m, HttpSession httpSession){

        String username= (String) httpSession.getAttribute("username");
        List<CartItem> cartItemList= cartDao.listCartItems(username);

        m.addAttribute("cartItemList", cartItemList);
        m.addAttribute("grandTotal", this.grandTotal(cartItemList));

        User user= userDao.getUser(username);

        String address= user.getCustomerAddress();
        m.addAttribute("addr", address);

        return "order/orderConfirm";
    }

    @RequestMapping(value = "/UpdateAddr", method = RequestMethod.POST)
    public String UpdateAddr(Model model, @RequestParam("addr") String addr, HttpSession httpSession){

        String username=(String) httpSession.getAttribute("username");
        List<CartItem> cartItemList= cartDao.listCartItems(username);

        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("grandTotal",this.grandTotal(cartItemList));

        User user=userDao.getUser(username);
        user.setCustomerAddress(addr);
        userDao.updateUser(user);

        String address= user.getCustomerAddress();
        model.addAttribute("addr", address);

        return "order/orderConfirm";
    }


    @RequestMapping(value = "/receipt", method = RequestMethod.POST)
    public String generateReceipt(Model model,@RequestParam("rd") String rd, HttpSession httpSession){

        String username=(String) httpSession.getAttribute("username");

        OrderDetail orderDetail= new OrderDetail();
        orderDetail.setOrderDate(new java.util.Date());
        orderDetail.setShippingAddress(userDao.getUser(username).getCustomerAddress());
        orderDetail.setTrans(rd);
        orderDetail.setUserName(username);


        List<CartItem> cartItemList= cartDao.listCartItems(username);

        model.addAttribute("cartItemList", cartItemList);
        model.addAttribute("grandTotal", this.grandTotal(cartItemList));

        User userDetail= userDao.getUser(username);
        orderDetail.setTotalAmount(this.grandTotal(cartItemList));


        orderDao.saveOrder(orderDetail);
        orderDao.updateCart(username);

        model.addAttribute("orderDetail", orderDetail);

        return "Receipt/receipt";
    }

    @RequestMapping(value = "/payment")
    public String paymentPage(Model model, HttpSession httpSession){
        return "Payment/payment";
    }
    public int grandTotal(List<CartItem> cartList){

        int  grandTotal=0, count=0;

        while (count<cartList.size()){
            grandTotal= (int) (grandTotal+(cartList.get(count).getQuantity()*cartList.get(count).getPrice()));
            count++;
        }

        return grandTotal;
    }
}
