package com.jimmy.cloud.quartz.dao;

import com.jimmy.cloud.quartz.base.BaseDao;
import com.jimmy.cloud.quartz.entity.JobAndTrigger;
import com.jimmy.cloud.quartz.entity.QrtzJobDetails;
import com.jimmy.cloud.quartz.mapper.QrtzJobDetailsMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * : qrtz_job_details
 * dao 层
 * @author henry
 */

@SuppressWarnings("unchecked")
@Repository("qrtzJobDetailsDao")
public class QrtzJobDetailsDao extends BaseDao<QrtzJobDetails, QrtzJobDetailsMapper, Integer> implements
		QrtzJobDetailsMapper{

	@Override
	public String getMapperNamesapce() {
		return QrtzJobDetailsMapper.class.getName().toString();
	}


	 public List<JobAndTrigger> getJobAndTriggerList(JobAndTrigger jobAndTrigger) {
		 return getSqlSession().selectList(getMapperNamesapce() + ".getJobAndTriggerList", jobAndTrigger);
	 }
 }