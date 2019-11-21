package com.jimmy.cloud.quartz.dao;

import com.jimmy.cloud.quartz.base.BaseDao;
import com.jimmy.cloud.quartz.entity.QrtzPausedTriggerGrps;
import com.jimmy.cloud.quartz.mapper.QrtzPausedTriggerGrpsMapper;
import org.springframework.stereotype.Repository;

 /**
 * : qrtz_paused_trigger_grps
 * dao 层
 * @author henry
 */

@SuppressWarnings("unchecked")
@Repository("qrtzPausedTriggerGrpsDao")
public class QrtzPausedTriggerGrpsDao extends BaseDao<QrtzPausedTriggerGrps, QrtzPausedTriggerGrpsMapper, Integer> implements
		QrtzPausedTriggerGrpsMapper{

	@Override
	public String getMapperNamesapce() {
		return QrtzPausedTriggerGrpsMapper.class.getName().toString();
	}


}