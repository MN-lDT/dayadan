package com.yadanoa.dayadan.service.serviceImpl;

import com.yadanoa.dayadan.dto.RepetoryDTO;
import com.yadanoa.dayadan.entity.RepertoryLog;
import com.yadanoa.dayadan.mapper.RepertoryServiceMapper;
import com.yadanoa.dayadan.service.IRepertoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepertoryServiceImpl implements IRepertoryService {
    @Autowired
    RepertoryServiceMapper repertoryServiceMapper;


    @Override
    public List<RepertoryLog> getAllRepetoryLogs(Integer pageSize, Integer pageNum) {
        return repertoryServiceMapper.getAllRepetoryLogs(pageSize,pageNum);
    }

    @Override
    public Integer getNowRepetoryCount() {
        return repertoryServiceMapper.getNowRepetoryCount();
    }

    @Override
    public Integer insertRepetoryLog(RepertoryLog repertoryLog) {
        return repertoryServiceMapper.insertRepetoryLog(repertoryLog);
    }


}
