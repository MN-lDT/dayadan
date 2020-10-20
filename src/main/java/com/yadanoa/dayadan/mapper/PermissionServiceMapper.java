package com.yadanoa.dayadan.mapper;

import com.yadanoa.dayadan.entity.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionServiceMapper {

    List<Permission> getPermissionsByRoleId (@Param("role_id") Integer roleId);
}
