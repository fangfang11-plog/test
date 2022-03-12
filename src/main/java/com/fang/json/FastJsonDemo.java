package com.fang.json;

import com.alibaba.fastjson.JSON;
import com.fang.pojo.User;

public class FastJsonDemo {
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("123");

        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);

        System.out.println(JSON.parseObject("{\"id\":1,\"password\":\"123\",\"username\":\"zhangsan\"}", User.class));
    }
}
