package com.example.xiaoheihe.service;


import com.example.xiaoheihe.config.annotation.DataSource;
import com.example.xiaoheihe.constants.SqlConstant;
import com.example.xiaoheihe.dao.DemoMapper;
import com.example.xiaoheihe.domain.Demo;
import com.example.xiaoheihe.enums.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DemoServiceImpl implements DemoService{

    @Autowired
    private DemoMapper demoMapper;

    @DataSource(DataSourceType.MASTER)
    public Map<String,Object> getDemoList(Demo demo) {
        List<Demo> dataList = demoMapper.selectDemoList(demo);
        Integer integer = demoMapper.selectCount(demo);

        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put(SqlConstant.LIST,dataList);
        dataMap.put(SqlConstant.TOTALNUM,integer);
        return dataMap;
    }
}
