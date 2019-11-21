package com.jimmy.cloud.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class ClientController {
    @GetMapping("add")
    public Map<String,Object> service(@RequestParam String userId) {
        Map<String,Object> userVo = new HashMap<>();
        userVo.put("userId",userId);
        userVo.put("userName","杰克");
        log.info("执行了");
        return userVo;
    }
}
