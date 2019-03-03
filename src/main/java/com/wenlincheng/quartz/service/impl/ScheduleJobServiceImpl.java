package com.wenlincheng.quartz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wenlincheng.quartz.mapper.ScheduleJobMapper;
import com.wenlincheng.quartz.pojo.ScheduleJob;
import com.wenlincheng.quartz.service.ScheduleJobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class ScheduleJobServiceImpl implements ScheduleJobService {

	@Resource
	private ScheduleJobMapper scheduleJobMapper;

	@Override
	public PageInfo<ScheduleJob> getJobAndTriggerDetails(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<ScheduleJob> list = scheduleJobMapper.getJobAndTriggerDetails();

		PageInfo<ScheduleJob> page = new PageInfo<ScheduleJob>(list);
		return page;
	}

}