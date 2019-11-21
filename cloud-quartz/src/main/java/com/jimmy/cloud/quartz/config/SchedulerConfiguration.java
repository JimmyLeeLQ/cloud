package com.jimmy.cloud.quartz.config;

import com.jimmy.cloud.quartz.job.QuartzJobFactory;
import lombok.extern.slf4j.Slf4j;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.ee.servlet.QuartzInitializerListener;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

//@Configuration
@Slf4j
public class SchedulerConfiguration {
    @Resource
    private QuartzJobFactory quartzJobFactory;

    @Resource
    private DataSource dataSource;

//    @Bean(name = "schedulerFactoryBean")
//    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
//        //获取配置属性
//        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
//        propertiesFactoryBean.setLocation(new ClassPathResource("quartz.properties"));
//        //在quartz.properties中的属性被读取并注入后再初始化对象
//        propertiesFactoryBean.afterPropertiesSet();
//        //创建SchedulerFactoryBean
//        SchedulerFactoryBean factory = new SchedulerFactoryBean();
//        Properties pro = propertiesFactoryBean.getObject();
//        factory.setOverwriteExistingJobs(true);
//        //factory.setAutoStartup(true);
//        factory.setDataSource(dataSource);
//        //factory.setQuartzProperties(pro);
//        factory.setJobFactory(quartzJobFactory);
//        return factory;
//    }

    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory) {
        SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
        try {
            factoryBean.setQuartzProperties(quartzProperties());
            factoryBean.setDataSource(dataSource);
            factoryBean.setJobFactory(jobFactory);
            factoryBean.setOverwriteExistingJobs(true);
        } catch (Exception e) {
            log.error("加载 {} 配置文件失败.","quartz.properties" , e);
            throw new RuntimeException("加载配置文件失败", e);
        }

        return factoryBean;
    }

    /**
     * quartz初始化监听器
     * 这个监听器可以监听到工程的启动，在工程停止再启动时可以让已有的定时任务继续进行。
     * 由于我们目前的工程是Spring Boot，没有web.xml的配置方式，
     * 所以我们在上文的SchedulerConfig类中直接注入了这个Bean。
     */
    @Bean
    public QuartzInitializerListener executorListener() {
        return new QuartzInitializerListener();
    }

    /**
     * 通过SchedulerFactoryBean获取Scheduler的实例
     */
    @Bean(name="scheduler")
    public Scheduler scheduler() throws IOException {
        return schedulerFactoryBean(quartzJobFactory).getScheduler();
    }

}
