package com.yadanoa.dayadan.service;

import com.yadanoa.dayadan.entity.Role;

public interface IRoleService {

    Role getRoleInfoByUserName (String username);

    Integer insertUserRoleVIP (Integer userId);
}
