package com.example.xiaoheihe.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.xiaoheihe.domain.Demo;
import com.example.xiaoheihe.domain.DemoBean;
//import com.example.xiaoheihe.domain.DemoBean2;
import com.example.xiaoheihe.domain.ExplainBean;
import com.example.xiaoheihe.resultEntity.Result;
import com.example.xiaoheihe.service.DemoService;
import com.example.xiaoheihe.utils.DownloadUtils;
import com.example.xiaoheihe.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;


@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private DemoBean demoBean;

    ThreadLocal<String> num = new ThreadLocal<>();

    @PostMapping("/getDemoList")
    public Result list(@RequestBody Demo demo){
        num.set("1234");
        return Result.success(demoService.getDemoList(demo));
    }

    @GetMapping("/download")
    public void download(HttpServletRequest request,HttpServletResponse response) throws IOException {
        InputStream resourceAsStream = DemoController.class.getResourceAsStream("/templates/doc-template.pdf");
        assert resourceAsStream != null;
        DownloadUtils.download(request,response,resourceAsStream,"doc-template.pdf");
    }


    @PostMapping("/testGlobalException")
    public void testGlobalException(){
        int i = 10/0;
        System.out.println(i);
    }


    @PostMapping("/testRedisCache")
    public Result testRedisCache(@RequestBody JSONObject jsonObject) throws InterruptedException {
        String key = jsonObject.getString("key");
        Demo demo = jsonObject.getJSONObject("value").toJavaObject(Demo.class);
        redisUtils.set(key, demo);
        Thread.sleep(1000);

        return Result.success(redisUtils.get(key));
    }

    @PostMapping("/testTransaction")
    @Transactional
    public Result testTransaction(){
        demoService.testTransaction();
        return Result.success();
    }

    @PostMapping("/explainBean")
    public Result explainBean(){
        List<ExplainBean> explainBeans = demoBean.getExplainBeans();
        return Result.success(explainBeans);
    }
}
