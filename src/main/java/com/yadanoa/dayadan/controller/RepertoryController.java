package com.yadanoa.dayadan.controller;

import com.google.common.collect.Maps;
import com.yadanoa.dayadan.Enum.OpTypeENUM;
import com.yadanoa.dayadan.entity.RepertoryLog;
import com.yadanoa.dayadan.entity.User;
import com.yadanoa.dayadan.service.IRepertoryService;
import com.yadanoa.dayadan.service.IUserService;
import com.yadanoa.dayadan.utils.ResponMode;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@Slf4j
public class RepertoryController {

    @Autowired
    IRepertoryService repertoryService;
    @Autowired
    IUserService userService;

    // 获取所有的操作记录 ，按照时间排序
    @RequestMapping(value = "getAllOpLog",method = RequestMethod.POST)
    @ResponseBody
    public ResponMode getAllOpLog (Integer pageSize,Integer pageNum) {
        ResponMode responMode = new ResponMode();
        List<RepertoryLog> allRepetoryLogs = repertoryService.getAllRepetoryLogs(pageSize, pageNum);
        Integer nowRepetoryCount = repertoryService.getNowRepetoryCount();
        if (nowRepetoryCount == null) {
            nowRepetoryCount = 0;
        }

        Map<String,Object> resultMap = Maps.newHashMap();
        resultMap.put("allRepetoryLogs",allRepetoryLogs);
        resultMap.put("nowRepetoryCount",nowRepetoryCount);

        responMode.setFlag(true);
        responMode.setMsg("获取成功");
        responMode.setData(resultMap);
        return responMode;
    }

    // 新增出库或者入库记录
    @RequestMapping(value = "addOpLog" , method = RequestMethod.POST)
    @ResponseBody
    public ResponMode addOpLog (Integer addCount,Integer cutKdCount,Integer cutQpCount) {
        Subject currentUser = SecurityUtils.getSubject();
        String username = (String)currentUser.getPrincipal();
        User user = userService.getUser(username);
        String type = "";
        if (addCount!=null && addCount>0) {
            type = OpTypeENUM.RK.getCode();
        }
        if ((cutKdCount!=null && cutKdCount>0) || (cutQpCount!=null &&cutQpCount>0)) {
            type = OpTypeENUM.CH.getCode();
        }
        if ((addCount!=null && addCount>0) && ((cutKdCount!=null && cutKdCount>0) || (cutQpCount!=null &&cutQpCount>0)) ) {
            type = OpTypeENUM.RKCK.getCode();
        }
        RepertoryLog repertoryLog = new RepertoryLog();
        repertoryLog.setAddCount(addCount);
        repertoryLog.setCreateDate(new Date());
        repertoryLog.setCutQpCount(cutQpCount);
        repertoryLog.setCutKdCount(cutKdCount);
        repertoryLog.setType(type);
        if (user!=null) {
            repertoryLog.setUser_id(user.getId());
        }
        Integer nowRepetoryCount = repertoryService.getNowRepetoryCount();
        if (nowRepetoryCount == null) {
            nowRepetoryCount = 0;
        }
        if (addCount!=null && addCount>0) {
            nowRepetoryCount = nowRepetoryCount+addCount;
        }
        if (cutKdCount!=null && cutKdCount>0) {
            nowRepetoryCount = nowRepetoryCount - cutKdCount;
        }
        if (cutQpCount!=null &&cutQpCount>0) {
            nowRepetoryCount = nowRepetoryCount - cutQpCount;
        }
        repertoryLog.setRepertoryNum(nowRepetoryCount);
        // 插入一条记录
        repertoryService.insertRepetoryLog(repertoryLog);
        ResponMode responMode = new ResponMode();
        responMode.setFlag(true);
        responMode.setMsg("新增成功");
        responMode.setData(null);
        return responMode;
    }
}
