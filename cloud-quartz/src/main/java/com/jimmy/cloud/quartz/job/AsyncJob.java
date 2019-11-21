package com.jimmy.cloud.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Slf4j
public class AsyncJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("========================立即执行的任务，只执行一次===============================");
        log.info("jobName=====:"+jobExecutionContext.getJobDetail().getKey().getName());
        log.info("jobGroup=====:"+jobExecutionContext.getJobDetail().getKey().getGroup());
        log.info("taskData=====:"+jobExecutionContext.getJobDetail().getJobDataMap().get("asyncData"));
    }
}
