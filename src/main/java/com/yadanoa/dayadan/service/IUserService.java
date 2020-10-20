package com.yadanoa.dayadan.service;

import com.yadanoa.dayadan.entity.User;

public interface IUserService {

    User getUser(String userName);

    void insertUser (String userName,String password);

}
