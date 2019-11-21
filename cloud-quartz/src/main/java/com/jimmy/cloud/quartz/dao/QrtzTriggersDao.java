package com.jimmy.cloud.quartz.dao;

import com.jimmy.cloud.quartz.base.BaseDao;
import com.jimmy.cloud.quartz.entity.QrtzTriggers;
import com.jimmy.cloud.quartz.mapper.QrtzTriggersMapper;
import org.springframework.stereotype.Repository;

 /**
 * : qrtz_triggers
 * dao 层
 * @author henry
 */

@SuppressWarnings("unchecked")
@Repository("qrtzTriggersDao")
public class QrtzTriggersDao extends BaseDao<QrtzTriggers, QrtzTriggersMapper, Integer> implements
		QrtzTriggersMapper{

	@Override
	public String getMapperNamesapce() {
		return QrtzTriggersMapper.class.getName().toString();
	}


}