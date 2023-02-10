package com.example.xiaoheihe.dao;


import com.example.xiaoheihe.domain.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DemoMapper {
    List<Demo> selectDemoList(Demo demo);

    Integer selectCount(Demo demo);
}
