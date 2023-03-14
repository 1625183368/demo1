package com.example.xiaoheihe.dao;


import com.example.xiaoheihe.domain.LoginUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<LoginUser> selectUserList(LoginUser demo);

    Integer selectCount(LoginUser demo);

}
