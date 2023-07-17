package com.example.xiaoheihe.domain;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class AbstractRequest<T> {
    private String url;
    private Class<T> clazz;

    public AbstractRequest() {
        super();
        ParameterizedType type = (ParameterizedType)this.getClass().getGenericSuperclass();
        clazz = (Class<T>) type.getActualTypeArguments()[0];
    }

    public String getUrl(){
        return this.url;
    }


//    public AbstractRequest(T t, String url) {
//        this.type = t.getClass().getGenericSuperclass();
//        this.url = url;
//    }

    public void sayHello() {
        System.out.println(getUrl());
    }

    public T sayHi(String entity){
        System.out.println(getUrl());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mRID","123456");
        jsonObject.put("remark","test<E> demo");
        return jsonObject.toJavaObject(clazz);
    }
}

class test{
    public static void main(String[] args) throws NoSuchFieldException {
//        AbstractRequest<String> request = new AbstractRequest<>();
        DemoRequest demoRequest = new DemoRequest();
//        Demo demo = new Demo();
        Demo demo = demoRequest.sayHi("null");
        System.out.println(demo.getmRID());
    }
}
