package com.yadanoa.dayadan.service.serviceImpl;

import com.yadanoa.dayadan.entity.Permission;
import com.yadanoa.dayadan.mapper.PermissionServiceMapper;
import com.yadanoa.dayadan.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    PermissionServiceMapper permissionServiceMapper;
    @Override
    public List<Permission> getPermissionsByRoleId(Integer roleId) {
        return permissionServiceMapper.getPermissionsByRoleId(roleId);
    }
}
