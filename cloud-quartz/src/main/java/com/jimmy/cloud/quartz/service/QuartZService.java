package com.jimmy.cloud.quartz.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(value = "QUARTZ-SERVICE", fallbackFactory = QuartzServiceFallbackFallbackFactory.class, configuration = {KeepErrMsgConfiguration.class})
public interface QuartZService {
    String QUARTZ_INDEX_URL = "/cloud-quartz/quartz/index";

    @RequestMapping(value = QUARTZ_INDEX_URL+"/{id}")
    Map<String, Object> index(@PathVariable("id") String id);

}