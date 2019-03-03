package com.wenlincheng.quartz.controller;

import com.github.pagehelper.PageInfo;
import com.wenlincheng.quartz.pojo.ScheduleJob;
import com.wenlincheng.quartz.service.ScheduleJobService;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/***
 * 定时任务管理
 * @Author: wenlincheng
 * @Date: 2019/3/3
 */
@RestController
@RequestMapping("/job")
public class ScheduleJobController {

    @Autowired
    private ScheduleJobService scheduleJobService;

    @Autowired
    private Scheduler scheduler;

    private static Logger log = LoggerFactory.getLogger(ScheduleJobController.class);

    /***
     * 页面
     * @Author: wenlincheng
     * @Date: 2019/3/3 
     * @param modelAndView: 
     * @return: org.springframework.web.servlet.ModelAndView
     */
    @RequestMapping("/index")
    public ModelAndView index(ModelAndView modelAndView) {

        modelAndView.setViewName("JobManager");

        return modelAndView;
    }

    /**
     * 添加任务
     */
    @PostMapping(value = "/addjob")
    public void addjob(@RequestParam(value = "jobClassName") String jobClassName, @RequestParam(value = "jobGroupName") String jobGroupName,
                       @RequestParam(value = "cronExpression") String cronExpression) throws Exception {

        // 启动调度器
        scheduler.start();

        // 构建job 信息
        Job job = (Job) Class.forName(jobClassName).newInstance();
        JobDetail jobDetail = JobBuilder.newJob(job.getClass()).withIdentity(jobClassName, jobGroupName).build();

        // 表达式调度构建器(即任务执行的时间)
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

        // 按新的cronExpression表达式构建一个新的trigger
        CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity(jobClassName, jobGroupName)
                .withSchedule(scheduleBuilder).build();

        try {
            scheduler.scheduleJob(jobDetail, trigger);

        } catch (SchedulerException e) {
            System.out.println("创建定时任务失败" + e);
            throw new Exception("创建定时任务失败");
        }

    }

    /***
     * 暂停任务
     * @Author: wenlincheng
     * @Date: 2019/3/3
     * @param jobClassName: 
     * @param jobGroupName:
     * @return: void
     */
    @PostMapping(value = "/pausejob")
    public void pausejob(@RequestParam(value = "jobClassName") String jobClassName, @RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
        scheduler.pauseJob(JobKey.jobKey(jobClassName, jobGroupName));
        log.info("暂停任务");
    }

    /***
     * 恢复任务
     * @Author: wenlincheng
     * @Date: 2019/3/3
     * @param jobClassName:
     * @param jobGroupName:
     * @return: void
     */
    @PostMapping(value = "/resumejob")
    public void resumejob(@RequestParam(value = "jobClassName") String jobClassName, @RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
        scheduler.resumeJob(JobKey.jobKey(jobClassName, jobGroupName));
        log.info("恢复任务");
    }

    /***
     * 更新定时任务
     * @Author: wenlincheng
     * @Date: 2019/3/3
     * @param jobClassName:
     * @param jobGroupName:
     * @param cronExpression:
     * @return: void
     */
    @PostMapping(value = "/reschedulejob")
    public void rescheduleJob(@RequestParam(value = "jobClassName") String jobClassName,
                              @RequestParam(value = "jobGroupName") String jobGroupName,
                              @RequestParam(value = "cronExpression") String cronExpression) throws Exception {
        try {
            TriggerKey triggerKey = TriggerKey.triggerKey(jobClassName, jobGroupName);
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression);

            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

            // 按新的cronExpression表达式重新构建trigger
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

            // 按新的trigger重新设置job执行
            scheduler.rescheduleJob(triggerKey, trigger);
        } catch (SchedulerException e) {
            System.out.println("更新定时任务失败" + e);
            throw new Exception("更新定时任务失败");
        }
    }

    /***
     * 删除任务
     * @Author: wenlincheng
     * @Date: 2019/3/3
     * @param jobClassName:
     * @param jobGroupName:
     * @return: void
     */
    @PostMapping(value = "/deletejob")
    public void deletejob(@RequestParam(value = "jobClassName") String jobClassName, @RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
        scheduler.pauseTrigger(TriggerKey.triggerKey(jobClassName, jobGroupName));
        scheduler.unscheduleJob(TriggerKey.triggerKey(jobClassName, jobGroupName));
        scheduler.deleteJob(JobKey.jobKey(jobClassName, jobGroupName));
    }

    /***
     * 查询任务
     * @Author: wenlincheng
     * @Date: 2019/3/3
     * @param pageNum:
     * @param pageSize:
     * @return: java.util.Map<java.lang.String   ,   java.lang.Object>
     */
    @GetMapping(value = "/queryjob")
    public Map<String, Object> queryjob(@RequestParam(value = "pageNum") Integer pageNum, @RequestParam(value = "pageSize") Integer pageSize) {
        PageInfo<ScheduleJob> jobAndTrigger = scheduleJobService.getJobAndTriggerDetails(pageNum, pageSize);

        Map<String, Object> map = new HashMap<>(10);
        map.put("JobAndTrigger", jobAndTrigger);
        map.put("number", jobAndTrigger.getTotal());

        return map;
    }

}
