package com.yadanoa.dayadan.mapper;

import com.yadanoa.dayadan.entity.Repertory;
import com.yadanoa.dayadan.entity.RepertoryLog;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepertoryServiceMapper {
    /***
     * 获取完整的操作记录
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<RepertoryLog> getAllRepetoryLogs (@Param("pageNum") Integer pageNum,@Param("pageSize") Integer pageSize) ;

    Integer getNowRepetoryCount () ;

    Integer insertRepetoryLog (RepertoryLog repertoryLog) ;
}
