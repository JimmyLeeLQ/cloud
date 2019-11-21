package com.jimmy.cloud.quartz.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * @Description: <RABBITMQ服务调用>
 * @Author: Jimmy
 * @CreateDate: 2019/11/13 19:57
 * @UpdateUser: Jimmy
 * @UpdateDate: 2019/11/13 19:57
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@FeignClient(value = "RABBITMQ-SERVICE")
public interface RabbitmqService {
    @GetMapping("/directSend/{msg}")
    void directSend(@PathVariable("msg") String msg);
}
