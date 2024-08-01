package com.example.xiaoheihe.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.xiaoheihe.resultEntity.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/testEx")
public class TestExClassLoadController {

    @PostMapping("/test")
    public Result test(@RequestBody JSONObject jsonObject){
        String flag = jsonObject.getString("flag");
        return Result.success(flag);
    }
}
