package com.tedu.sp04.order.feignclient;

import com.tedu.sp01.pojo.Item;
import com.tedu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "order-service", fallback = ItemFeignServiceFB.class)
public interface ItemFeignService {

    @RequestMapping("/{orderId}")
    JsonResult<List<Item>> getItems(@PathVariable String orderId);

    @RequestMapping("/decreaseNumber")
    JsonResult decreaseNumber(@RequestBody List<Item> items);

}
