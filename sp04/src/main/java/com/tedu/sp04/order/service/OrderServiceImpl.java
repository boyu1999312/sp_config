package com.tedu.sp04.order.service;

import com.tedu.sp01.pojo.Item;
import com.tedu.sp01.pojo.User;
import com.tedu.sp04.order.feignclient.ItemFeignService;
import com.tedu.sp04.order.feignclient.UserFeignService;
import com.tedu.web.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tedu.sp01.pojo.Order;
import com.tedu.sp01.service.OrderService;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ItemFeignService itemFeignService;
    @Autowired
    private UserFeignService userFeignService;

    //根据订单ID获取订单数据 包含订单用户信息 要包含订单中的商品信息
    @Override
    public Order getOrder(String orderId) {
        //TODO: 调用user-service获取用户信息
        JsonResult<User> user = userFeignService.getUser(7);
        //TODO: 调用item-service获取商品信息
        JsonResult<List<Item>> items = itemFeignService.getItems(orderId);
        Order order = new Order();
        order.setId(orderId);
        order.setUser(user.getData());
        order.setItems(items.getData());
        return order;
    }

    //添加订单 修改商品库存，修改用户积分
    @Override
    public void addOrder(Order order) {
        //TODO: 调用item-service减少商品库存
        itemFeignService.decreaseNumber(order.getItems());
        //TODO: 调用user-service增加用户积分
        userFeignService.addScore(7, 100);
        log.info("保存订单："+order);
    }
}