package com.yadanoa.dayadan.service;

import com.yadanoa.dayadan.entity.Permission;

import java.util.List;

public interface IPermissionService {

    List<Permission> getPermissionsByRoleId (Integer roleId);
}
