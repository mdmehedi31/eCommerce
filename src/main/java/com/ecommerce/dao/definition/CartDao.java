package com.ecommerce.dao.definition;

import com.ecommerce.entity.CartItem;

import java.util.List;

public interface CartDao {


    public boolean addCartItem(CartItem cartItem);

    public boolean deleteCartItem(CartItem cartItem);
    public boolean updateCartItem (CartItem cartItem);
    public CartItem getCartItem(int cartItemId);
    public List<CartItem> listCartItems(String userName);

}
