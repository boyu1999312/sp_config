package com.tedu.sp09.service;

import com.tedu.sp01.pojo.Order;
import com.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceFB implements OrderFeignService{

    @Override
    public JsonResult<Order> getOrder(String orderId) {
        return JsonResult.err("无法获取订单列表");
    }

    @Override
    public JsonResult addOrder() {
        return JsonResult.err("无法新增订单");
    }
}
