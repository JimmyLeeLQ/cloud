package com.jimmy.cloud.common.controller;

import com.jimmy.cloud.common.zookeeper.IDGenerator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("idGenerator")
public class IDGeneratorController {

    @Resource
    private IDGenerator idGenerator;

    @RequestMapping("/createId")
    public long createId(){
        return idGenerator.nextId();
    }

}
