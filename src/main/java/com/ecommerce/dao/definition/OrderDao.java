package com.ecommerce.dao.definition;

import com.ecommerce.entity.OrderDetail;

public interface OrderDao {

    public boolean saveOrder(OrderDetail orderDetail);
    public boolean updateCart(String userName);

}
