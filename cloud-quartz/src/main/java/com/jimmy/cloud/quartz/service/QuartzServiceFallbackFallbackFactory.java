package com.jimmy.cloud.quartz.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class QuartzServiceFallbackFallbackFactory implements FallbackFactory<QuartZService>{

    private Map<String, Object> index(String id) {
        Map<String, Object> retMap = new HashMap<>();
        retMap.put("retCode","-1");
        retMap.put("id",id);
        retMap.put("retMsg","调用QuartZController index fail,降级回调 QuartzServiceFallback index");
        return retMap;
    }

    @Override
    public QuartZService create(Throwable throwable) {
        return (s)-> {
            Map<String, Object> retMap = index(s);
            retMap.put("exception",throwable);
            return retMap;
        };
    }
}
