package com.jimmy.cloud.quartz.dao;

import com.jimmy.cloud.quartz.base.BaseDao;
import com.jimmy.cloud.quartz.entity.QrtzLocks;
import com.jimmy.cloud.quartz.mapper.QrtzLocksMapper;
import org.springframework.stereotype.Repository;

 /**
 * : qrtz_locks
 * dao 层
 * @author henry
 */

@SuppressWarnings("unchecked")
@Repository("qrtzLocksDao")
public class QrtzLocksDao extends BaseDao<QrtzLocks, QrtzLocksMapper, Integer> implements
		QrtzLocksMapper{

	@Override
	public String getMapperNamesapce() {
		return QrtzLocksMapper.class.getName().toString();
	}


}