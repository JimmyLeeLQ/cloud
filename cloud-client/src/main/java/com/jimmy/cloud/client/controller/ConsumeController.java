package com.jimmy.cloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ConsumeController {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/add")
    public Map<String,Object> query(String userId) {
        // 通过注册中心找到PRODUCER-SERVICE的服务，服务端已经做负载均衡
        return restTemplate.getForObject("http://PRODUCER-SERVICE/add?userId=" + userId, Map.class);
    }

    @GetMapping("hello")
    //@PreAuthorize("hasAnyAuthority('hello')")
    public String hello(){
        return "hello";
    }

    @GetMapping("current")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("query")
    //@PreAuthorize("hasAnyAuthority('query')")
    public String query() {
        return "具有query权限";
    }

    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        list.remove(2);
        list.remove(3);
        System.out.println(list);
    }

}
