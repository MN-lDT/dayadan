package com.yadanoa.dayadan.mapper;

import com.yadanoa.dayadan.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceMapper {

    User getUser(@Param("username") String userName);

    Integer insertUser (@Param("username")String username,@Param("password") String password);

}
