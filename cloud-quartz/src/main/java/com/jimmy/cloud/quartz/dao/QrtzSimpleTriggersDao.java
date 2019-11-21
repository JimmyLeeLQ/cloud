package com.jimmy.cloud.quartz.dao;

import com.jimmy.cloud.quartz.base.BaseDao;
import com.jimmy.cloud.quartz.entity.QrtzSimpleTriggers;
import com.jimmy.cloud.quartz.mapper.QrtzSimpleTriggersMapper;
import org.springframework.stereotype.Repository;

 /**
 * : qrtz_simple_triggers
 * dao 层
 * @author henry
 */

@SuppressWarnings("unchecked")
@Repository("qrtzSimpleTriggersDao")
public class QrtzSimpleTriggersDao extends BaseDao<QrtzSimpleTriggers, QrtzSimpleTriggersMapper, Integer> implements
		QrtzSimpleTriggersMapper{

	@Override
	public String getMapperNamesapce() {
		return QrtzSimpleTriggersMapper.class.getName().toString();
	}


}