package com.keyt.test_1.service;

import com.keyt.test_1.bean.UserBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {

    List<UserBean> getAllUser();

    UserBean getUserByUsernameAndPassword(String username,String password);
}
