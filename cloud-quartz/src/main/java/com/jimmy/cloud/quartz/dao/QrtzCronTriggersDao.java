package com.jimmy.cloud.quartz.dao;

import com.jimmy.cloud.quartz.base.BaseDao;
import com.jimmy.cloud.quartz.entity.QrtzCronTriggers;
import com.jimmy.cloud.quartz.mapper.QrtzCronTriggersMapper;
import org.springframework.stereotype.Repository;

 /**
 * : qrtz_cron_triggers
 * dao 层
 * @author henry
 */

@SuppressWarnings("unchecked")
@Repository("qrtzCronTriggersDao")
public class QrtzCronTriggersDao extends BaseDao<QrtzCronTriggers, QrtzCronTriggersMapper, Integer> implements
		QrtzCronTriggersMapper{

	@Override
	public String getMapperNamesapce() {
		return QrtzCronTriggersMapper.class.getName().toString();
	}


}