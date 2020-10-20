package com.yadanoa.dayadan.service;

import com.yadanoa.dayadan.dto.RepetoryDTO;
import com.yadanoa.dayadan.entity.RepertoryLog;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IRepertoryService {

    List<RepertoryLog> getAllRepetoryLogs(Integer pageSize, Integer pageNum);

    Integer getNowRepetoryCount();

    Integer insertRepetoryLog (RepertoryLog repertoryLog);

}
