package com.example.xiaoheihe.controller;


import com.example.xiaoheihe.domain.Demo;
import com.example.xiaoheihe.resultEntity.Result;
import com.example.xiaoheihe.service.DemoService;
import com.example.xiaoheihe.utils.DownloadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;


@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @RequestMapping("/getDemoList")
    public Result list(@RequestBody Demo demo){
        return Result.success(demoService.getDemoList(demo));
    }

    @RequestMapping("/download")
    public void download(HttpServletRequest request,HttpServletResponse response) throws IOException {
        File file = new File("application.yml");
        DownloadUtils.download(request,response,file);


        HashMap<Object, Object> map = new HashMap<>();
        map.forEach((k,v)->{});
    }

}
