package com.jimmy.cloud.quartz.job;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;
import org.springframework.stereotype.Component;

/**
 * @Description:    <创建job 实例工厂，解决spring注入问题，如果使用默认会导致spring的@Autowired 无法注入问题>
 * @Author:         Jimmy
 * @CreateDate:     2019/11/12 11:34
 * @UpdateUser:     Jimmy
 * @UpdateDate:     2019/11/12 11:34
 * @UpdateRemark:   修改内容
 * @Version:        1.0
 */
@Component
public class QuartzJobFactory extends SpringBeanJobFactory implements ApplicationContextAware{
    /**
     * 不被序列化
     */
    private transient AutowireCapableBeanFactory beanFactory;

    @Override
    public void setApplicationContext(final ApplicationContext context) {
        beanFactory = context.getAutowireCapableBeanFactory();
    }

    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
        final Object job = super.createJobInstance(bundle);
        beanFactory.autowireBean(job);
        return job;
    }
}
