package com.wenlincheng.quartz.service;


import com.github.pagehelper.PageInfo;
import com.wenlincheng.quartz.pojo.ScheduleJob;

/**
 * 定时任务
 * @Author: wenlincheng
 * @Date: 2019/3/3
 */
public interface ScheduleJobService {
    /***
     * 查询定时任务
     * @Author: wenlincheng
     * @Date: 2019/3/3
     * @param pageNum:
      * @param pageSize:
     * @return: com.github.pagehelper.PageInfo<com.wenlincheng.quartz.pojo.JobAndTrigger>
     */
    PageInfo<ScheduleJob> getJobAndTriggerDetails(int pageNum, int pageSize);

}
