package com.jimmy.cloud.quartz.dao;

import com.jimmy.cloud.quartz.base.BaseDao;
import com.jimmy.cloud.quartz.entity.QrtzBlobTriggers;
import com.jimmy.cloud.quartz.mapper.QrtzBlobTriggersMapper;
import org.springframework.stereotype.Repository;


 /**
 * : qrtz_blob_triggers
 * dao 层
 * @author henry
 */

@SuppressWarnings("unchecked")
@Repository("qrtzBlobTriggersDao")
public class QrtzBlobTriggersDao extends BaseDao<QrtzBlobTriggers, QrtzBlobTriggersMapper, Integer> implements
		 QrtzBlobTriggersMapper {

	@Override
	public String getMapperNamesapce() {
		return QrtzBlobTriggersMapper.class.getName().toString();
	}


}