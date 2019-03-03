package com.wenlincheng.quartz.pojo;

import java.io.Serializable;
import java.math.BigInteger;

/***
 *  封装任务和触发器
 * @Author: wenlincheng
 * @Date: 2019/3/3
 */
public class ScheduleJob implements Serializable {
    private static final long serialVersionUID = 3834374101376445346L;
    /**
     * 任务名称
     */
	private String jobName;
	/**
	 * 任务组
	 */
	private String jobGroup;

	/**
	 * 任务描述
	 */
	private String jobDescription;

	/**
	 * 任务类名
	 */
	private String jobClassName;
	/**
	 * 触发器的名字
	 */
	private String triggerName;

	/**
	 * 触发器描述
	 */
	private String triggerDescription;

    /**
     * 触发器状态
     */
    private String triggerState;

	/**
	 * 触发器组
	 */
	private String triggerGroup;

	/**
	 * 下一次执行时间，
	 */
	private BigInteger nextFireTime;

	/**
	 * 上一次执行时间
	 */
	private BigInteger prevFireTime;

	/**
	 * 重复次数，简单trigger 中
	 */
	private BigInteger repeatInterval;

	/**
	 * 已经执行次数，简单trigger 中
	 */
	private BigInteger timesTriggered;

	/**
	 * cron 表达式
	 */
	private String cronExpression;

	/**
	 * 时区
	 */
	private String timeZoneId;


    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobClassName() {
        return jobClassName;
    }

    public void setJobClassName(String jobClassName) {
        this.jobClassName = jobClassName;
    }

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerDescription() {
        return triggerDescription;
    }

    public void setTriggerDescription(String triggerDescription) {
        this.triggerDescription = triggerDescription;
    }

    public String getTriggerState() {
        return triggerState;
    }

    public void setTriggerState(String triggerState) {
        this.triggerState = triggerState;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public BigInteger getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(BigInteger nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    public BigInteger getPrevFireTime() {
        return prevFireTime;
    }

    public void setPrevFireTime(BigInteger prevFireTime) {
        this.prevFireTime = prevFireTime;
    }

    public BigInteger getRepeatInterval() {
        return repeatInterval;
    }

    public void setRepeatInterval(BigInteger repeatInterval) {
        this.repeatInterval = repeatInterval;
    }

    public BigInteger getTimesTriggered() {
        return timesTriggered;
    }

    public void setTimesTriggered(BigInteger timesTriggered) {
        this.timesTriggered = timesTriggered;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getTimeZoneId() {
        return timeZoneId;
    }

    public void setTimeZoneId(String timeZoneId) {
        this.timeZoneId = timeZoneId;
    }

    @Override
    public String toString() {
        return "ScheduleJob{" +
                "jobName='" + jobName + '\'' +
                ", jobGroup='" + jobGroup + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", jobClassName='" + jobClassName + '\'' +
                ", triggerName='" + triggerName + '\'' +
                ", triggerDescription='" + triggerDescription + '\'' +
                ", triggerState='" + triggerState + '\'' +
                ", triggerGroup='" + triggerGroup + '\'' +
                ", nextFireTime=" + nextFireTime +
                ", prevFireTime=" + prevFireTime +
                ", repeatInterval=" + repeatInterval +
                ", timesTriggered=" + timesTriggered +
                ", cronExpression='" + cronExpression + '\'' +
                ", timeZoneId='" + timeZoneId + '\'' +
                '}';
    }
}
