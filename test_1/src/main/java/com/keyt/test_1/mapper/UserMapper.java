package com.keyt.test_1.mapper;


import com.keyt.test_1.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<UserBean> getAllUser();

    UserBean getUserByUsernameAndPassword(@Param("username")String username,@Param("password")String password);
}
