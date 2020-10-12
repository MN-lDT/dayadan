package com.yadanoa.dayadan.controller;

import com.yadanoa.dayadan.entity.testEntity;
import com.yadanoa.dayadan.service.ItestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class testController {

    @Autowired
    private ItestService testService;

    @RequestMapping(value = "/getTestData")
    @ResponseBody
    public String getData () {
        log.info("------------");
        testEntity data = testService.getData(1926);
        return data.getName();
    }
}
