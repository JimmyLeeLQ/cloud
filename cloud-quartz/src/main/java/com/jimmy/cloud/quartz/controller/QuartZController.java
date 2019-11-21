package com.jimmy.cloud.quartz.controller;

import com.jimmy.cloud.quartz.service.IDGeneratorService;
import com.jimmy.cloud.quartz.service.QuartZService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/quartz")
@Slf4j
public class QuartZController {

    @Resource
    private QuartZService quartZService;

    @Resource
    private IDGeneratorService idGeneratorService;

    @Value("${server.port}")
    private String port;

    @HystrixCommand(fallbackMethod = "indexFallback")
    @RequestMapping("/index/{id}")
    public Map<String,Object> index(@PathVariable("id") String id){
        if ("1".equals(id)){
            System.out.println(Integer.valueOf(id)/0);
        }
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("retCode","0");
        retMap.put("retMsg","调用QuartZController index success");
        retMap.put("port",port);
        retMap.put("uniqueId",idGeneratorService.getUniId());
        //System.out.println(3/0);
        return retMap;
    }
    /**
     * @Description:   <熔断调用方法>
      * @param id
     * @return:
     * @auther:        Jimmy
     * @date:          2019/11/10 11:08
     */
    public Map<String,Object> indexFallback(@PathVariable("id") String id){
        Map<String,Object> retMap = new HashMap<>();
        retMap.put("retCode","-2");
        retMap.put("id",id);
        retMap.put("retMsg","调用index失败,熔断调用indexFallback");
        retMap.put("port",port);
        return retMap;
    }

    @RequestMapping("/say/{id}")
    public Map<String,Object> say(@PathVariable("id") String id){
        return quartZService.index(id);
    }

}
