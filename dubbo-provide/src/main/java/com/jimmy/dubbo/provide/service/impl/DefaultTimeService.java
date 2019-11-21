package com.jimmy.dubbo.provide.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jimmy.dubbo.provide.service.TimeService;


import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @Description:    <java类作用描述>
 * @Author:         Jimmy
 * @CreateDate:     2019/11/14 18:24
 * @UpdateUser:     Jimmy
 * @UpdateDate:     2019/11/14 18:24
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */
@Service(
        version = "${hello.service.version}",
        application = "${dubbo.application.id}",
        registry = "${dubbo.registry.id}"
)
public class DefaultTimeService implements TimeService{
    public String getTime() {
        return TimeZone.getDefault().getDisplayName()+new SimpleDateFormat("Y年M月d日H时m分s秒").format(System.currentTimeMillis());
    }
}
