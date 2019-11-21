package com.jimmy.cloud.quartz.dao;

import com.jimmy.cloud.quartz.base.BaseDao;
import com.jimmy.cloud.quartz.entity.QrtzCalendars;
import com.jimmy.cloud.quartz.mapper.QrtzCalendarsMapper;
import org.springframework.stereotype.Repository;



 /**
 * : qrtz_calendars
 * dao 层
 * @author henry
 */

@SuppressWarnings("unchecked")
@Repository("qrtzCalendarsDao")
public class QrtzCalendarsDao extends BaseDao<QrtzCalendars, QrtzCalendarsMapper, Integer> implements
		QrtzCalendarsMapper{

	@Override
	public String getMapperNamesapce() {
		return QrtzCalendarsMapper.class.getName().toString();
	}


}