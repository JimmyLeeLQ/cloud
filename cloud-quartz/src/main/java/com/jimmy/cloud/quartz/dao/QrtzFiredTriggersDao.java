package com.jimmy.cloud.quartz.dao;


import com.jimmy.cloud.quartz.base.BaseDao;
import com.jimmy.cloud.quartz.entity.QrtzFiredTriggers;
import com.jimmy.cloud.quartz.mapper.QrtzFiredTriggersMapper;
import org.springframework.stereotype.Repository;

 /**
 * : qrtz_fired_triggers
 * dao 层
 * @author henry
 */

@SuppressWarnings("unchecked")
@Repository("qrtzFiredTriggersDao")
public class QrtzFiredTriggersDao extends BaseDao<QrtzFiredTriggers, QrtzFiredTriggersMapper, Integer> implements
		QrtzFiredTriggersMapper{

	@Override
	public String getMapperNamesapce() {
		return QrtzFiredTriggersMapper.class.getName().toString();
	}


}