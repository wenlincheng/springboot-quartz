package com.wenlincheng.quartz.mapper;

import com.wenlincheng.quartz.pojo.ScheduleJob;

import java.util.List;

public interface ScheduleJobMapper {
    /***
     *  查询任务列表
     * @Author: wenlincheng
     * @Date: 2019/3/3
     * @return: java.util.List<com.wenlincheng.quartz.pojo.JobAndTrigger>
     */
    List<ScheduleJob> getJobAndTriggerDetails();
}
