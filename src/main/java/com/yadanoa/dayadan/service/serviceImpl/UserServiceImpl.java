package com.yadanoa.dayadan.service.serviceImpl;

import com.yadanoa.dayadan.entity.User;
import com.yadanoa.dayadan.mapper.RoleServiceMapper;
import com.yadanoa.dayadan.mapper.UserServiceMapper;
import com.yadanoa.dayadan.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    UserServiceMapper userServiceMapper;
    @Autowired
    RoleServiceMapper roleServiceMapper;
    @Override
    public User getUser(String userName) {
        return  userServiceMapper.getUser(userName);
    }

    @Override
    public void insertUser(String userName, String password) {
        Integer id = userServiceMapper.insertUser(userName, password);
        // 默认设置用户为VIP 用户
        roleServiceMapper.insertUserRole(id);
    }
}
