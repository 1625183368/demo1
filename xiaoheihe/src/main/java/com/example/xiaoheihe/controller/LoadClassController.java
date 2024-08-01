package com.example.xiaoheihe.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.xiaoheihe.TestMain._0130.MyclassLoader;
import com.example.xiaoheihe.resultEntity.Result;
import com.example.xiaoheihe.service.ExtendsClassService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestController
@RequestMapping("/loadClass")
public class LoadClassController {

    @PostMapping("/load")
    public Result loadClass(@RequestBody JSONObject jsonObject) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        String path = jsonObject.getString("path");
        String name = jsonObject.getString("name");
        MyclassLoader myclassLoader = new MyclassLoader(path);
        Class<?> aClass = myclassLoader.loadClass(name);

//        Method extendsClassMethod = aClass.getDeclaredMethod("extendsClassMethod", String.class);

        ExtendsClassService extendsClassObject = (ExtendsClassService) aClass.newInstance();
        String params = "id:P001,name:DJ,lyrics:流水落花春去也天上人间";
        JSONObject result = extendsClassObject.extendsClassMethod(params);
        return Result.success(result);
//        extendsClassMethod.invoke(extendsClassObject, jsonObject);
    }
}
