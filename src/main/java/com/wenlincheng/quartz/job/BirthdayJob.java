package com.wenlincheng.quartz.job;

import java.util.Date;

import org.quartz.Job;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;   
import org.quartz.JobExecutionContext;  
import org.quartz.JobExecutionException;  
  
/***
 * 发送生日祝福给女神
 * @Author: wenlincheng
 * @Date: 2019/3/3
 */
public class BirthdayJob implements Job {
  
    private static Logger log = LoggerFactory.getLogger(BirthdayJob.class);

    @Override
    public void execute(JobExecutionContext context) {
        log.info("BirthdayJob执行时间: " + new Date());
    }
}  
