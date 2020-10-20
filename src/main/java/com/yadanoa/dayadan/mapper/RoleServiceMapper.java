package com.yadanoa.dayadan.mapper;

import com.yadanoa.dayadan.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleServiceMapper {

    Role getRoleInfoByUserName(String username);

    Integer insertUserRole (@Param("userId")Integer userId);
}
