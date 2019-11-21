package com.jimmy.cloud.quartz.dao;

import com.jimmy.cloud.quartz.base.BaseDao;
import com.jimmy.cloud.quartz.entity.QrtzSimpropTriggers;
import com.jimmy.cloud.quartz.mapper.QrtzSimpropTriggersMapper;
import org.springframework.stereotype.Repository;

 /**
 * : qrtz_simprop_triggers
 * dao 层
 * @author henry
 */

@SuppressWarnings("unchecked")
@Repository("qrtzSimpropTriggersDao")
public class QrtzSimpropTriggersDao extends BaseDao<QrtzSimpropTriggers, QrtzSimpropTriggersMapper, Integer> implements
		QrtzSimpropTriggersMapper{

	@Override
	public String getMapperNamesapce() {
		return QrtzSimpropTriggersMapper.class.getName().toString();
	}


}