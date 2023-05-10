package com.example.xiaoheihe.service.impl;


import com.example.xiaoheihe.config.annotation.DataSource;
import com.example.xiaoheihe.constants.SqlConstant;
import com.example.xiaoheihe.dao.DemoMapper;
import com.example.xiaoheihe.domain.Demo;
import com.example.xiaoheihe.enums.DataSourceType;
import com.example.xiaoheihe.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private DemoMapper demoMapper;
    @Autowired
    private DemoServiceImpl demoService;

    @DataSource(DataSourceType.MASTER)
    public Map<String,Object> getDemoList(Demo demo) {
        demoService.testDataSource();


        List<Demo> dataList = demoMapper.selectDemoList(demo);
        Integer integer = demoMapper.selectCount(demo);

        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put(SqlConstant.LIST,dataList);
        dataMap.put(SqlConstant.TOTALNUM,integer);
        return dataMap;
    }

    @DataSource(DataSourceType.MASTER)
    public void testDataSource() {
        System.out.println("-----------------");

//        List<Demo> dataList = demoMapper.selectDemoList(demo);
//        Integer integer = demoMapper.selectCount(demo);
//
//        HashMap<String, Object> dataMap = new HashMap<String, Object>();
//        dataMap.put(SqlConstant.LIST,dataList);
//        dataMap.put(SqlConstant.TOTALNUM,integer);
//        return dataMap;
    }

    @Override
    @Transactional
    public void testTransaction() {
        Demo demo = new Demo();
        demo.setmRID("77777777");
        demo.setDmlCode("i");
        demo.setCreator("admin1");
        demoMapper.insert(demo);

        demo.setCreator("admin2");
        demo.setmRID("666666667");
        demoMapper.insert(demo);

//        int i = 1/0;
//        demo.setmRID("555555");
//        demoMapper.insert(demo);
    }
}
