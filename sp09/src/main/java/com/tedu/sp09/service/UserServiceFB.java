package com.tedu.sp09.service;

import com.tedu.sp01.pojo.User;
import com.tedu.web.util.JsonResult;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFB implements UserFeignService{

    @Override
    public JsonResult<User> getUser(Integer userId) {
        return JsonResult.err("无法获取用户列表");
    }

    @Override
    public JsonResult addScore(Integer userId, Integer score) {
        return JsonResult.err("新增用户积分失败");
    }
}
