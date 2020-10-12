package com.yadanoa.dayadan.mapper;

import com.yadanoa.dayadan.entity.testEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestMapper {
    testEntity getData (@Param("id") Integer id) ;
}
