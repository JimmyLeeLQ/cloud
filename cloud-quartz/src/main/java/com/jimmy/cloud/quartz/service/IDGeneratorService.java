package com.jimmy.cloud.quartz.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "COMMON-SERVICE")
public interface IDGeneratorService {
    @RequestMapping("/idGenerator/createId")
    long getUniId();
}

