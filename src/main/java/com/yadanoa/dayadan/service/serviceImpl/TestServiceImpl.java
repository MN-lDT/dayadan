package com.yadanoa.dayadan.service.serviceImpl;

import com.yadanoa.dayadan.entity.testEntity;
import com.yadanoa.dayadan.mapper.TestMapper;
import com.yadanoa.dayadan.service.ItestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements ItestService {

    @Autowired
    TestMapper testMappernew;

    @Override
    public testEntity getData(Integer id) {
        testEntity data = testMappernew.getData(id);
        return data;
    }
}
