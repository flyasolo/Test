package com.keyt.test_1.serviceImpl;


import com.keyt.test_1.bean.UserBean;
import com.keyt.test_1.mapper.UserMapper;
import com.keyt.test_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserBean> getAllUser() {
        return userMapper.getAllUser();
    }
}
