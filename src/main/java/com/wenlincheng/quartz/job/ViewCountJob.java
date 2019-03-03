package com.wenlincheng.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/***
 * 定时更新文章浏览次数
 * @Author: wenlincheng
 * @Date: 2019/3/3
 */
public class ViewCountJob implements Job {

    private static Logger log = LoggerFactory.getLogger(ViewCountJob.class);

    @Override
    public void execute(JobExecutionContext context) {
        log.info("ViewCountJob执行时间: " + new Date());

    }
}  