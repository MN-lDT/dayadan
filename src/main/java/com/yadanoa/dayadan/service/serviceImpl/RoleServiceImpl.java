package com.yadanoa.dayadan.service.serviceImpl;

import com.yadanoa.dayadan.entity.Role;
import com.yadanoa.dayadan.mapper.RoleServiceMapper;
import com.yadanoa.dayadan.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements IRoleService {
    @Autowired
    RoleServiceMapper roleServiceMapper;
    @Override
    public Role getRoleInfoByUserName(String username) {
        return roleServiceMapper.getRoleInfoByUserName(username);
    }

    @Override
    public Integer insertUserRoleVIP(Integer userId) {
        return null;
    }

}
