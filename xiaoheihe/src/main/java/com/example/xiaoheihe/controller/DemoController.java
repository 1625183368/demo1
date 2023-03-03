package com.example.xiaoheihe.controller;


import com.example.xiaoheihe.domain.Demo;
import com.example.xiaoheihe.resultEntity.Result;
import com.example.xiaoheihe.service.DemoService;
import com.example.xiaoheihe.utils.DownloadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;


@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @PostMapping("/getDemoList")
    public Result list(@RequestBody Demo demo){
        return Result.success(demoService.getDemoList(demo));
    }

    @PostMapping("/download")
    public void download(HttpServletRequest request,HttpServletResponse response) throws IOException {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("application-dev.yml");
        assert resourceAsStream != null;
        DownloadUtils.download(request,response,resourceAsStream,"application-dev.yml");

    }

    @PostMapping("/testGlobalException")
    public void testGlobalException(){
        int i = 10/0;
        System.out.println(i);
    }

}
