package com.example.xiaoheihe.controller;


import com.example.xiaoheihe.domain.Demo;
import com.example.xiaoheihe.resultEntity.Result;
import com.example.xiaoheihe.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/getDemoList")
    public Result list(@RequestBody Demo demo){
        return Result.success(demoService.getDemoList(demo));
    }
}
