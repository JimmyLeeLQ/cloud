package com.jimmy.cloud.quartz.dao;

import com.jimmy.cloud.quartz.base.BaseDao;
import com.jimmy.cloud.quartz.entity.QrtzSchedulerState;
import com.jimmy.cloud.quartz.mapper.QrtzSchedulerStateMapper;
import org.springframework.stereotype.Repository;

 /**
 * : qrtz_scheduler_state
 * dao 层
 * @author henry
 */

@SuppressWarnings("unchecked")
@Repository("qrtzSchedulerStateDao")
public class QrtzSchedulerStateDao extends BaseDao<QrtzSchedulerState, QrtzSchedulerStateMapper, Integer> implements
		QrtzSchedulerStateMapper{

	@Override
	public String getMapperNamesapce() {
		return QrtzSchedulerStateMapper.class.getName().toString();
	}


}