package com.jimmy.cloud.quartz.controller;

import com.google.gson.Gson;
import com.jimmy.cloud.quartz.service.RabbitmqService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: <Rabbitmq 消息发送分发器>
 * @Author: Jimmy
 * @CreateDate: 2019/11/13 20:03
 * @UpdateUser: Jimmy
 * @UpdateDate: 2019/11/13 20:03
 * @UpdateRemark: 修改内容
 * @Version: 1.0
 */
@RestController
@RequestMapping("/rabbitmq")
@Slf4j
public class RabbitmqController {


    public static final String AUTH_SERVER_URI = "http://GATEWAY-SERVICE/auth/oauth/token?grant_type=password&client_id=jimmy&client_secret=123&scope=read&username=jimmy&password=123";

    public static final String MEMBER_SERVER_URI = "http://GATEWAY-SERVICE/member/api/add?";

    @Resource
    private RabbitmqService rabbitmqService;

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("directSend/{msg}")
    public void directSend(@PathVariable("msg") String msg) {
        //获取token,；支持post
        HttpEntity<String> request = new HttpEntity<>(getHeadersWithClientCredentials());
        ResponseEntity<Object> response = restTemplate.exchange(AUTH_SERVER_URI , HttpMethod.POST, request, Object.class);
        LinkedHashMap<String, Object> objectMap = (LinkedHashMap<String, Object>) response.getBody();
        String accessToken = objectMap.get("access_token").toString();
        log.info("objectMap:{}",objectMap);
        Map<String, Object> retMap = restTemplate.getForObject(MEMBER_SERVER_URI+"access_token="+accessToken+"&userId="+msg, Map.class);
        rabbitmqService.directSend(new Gson().toJson(retMap));
    }

    /*
     * Add HTTP Authorization header, using Basic-Authentication to send client-credentials.
     */
    private static HttpHeaders getHeadersWithClientCredentials() {
        String plainClientCredentials = "jimmy:123";
        String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));
        HttpHeaders headers = getHeaders();
        headers.add("Authorization", "Basic " + base64ClientCredentials);
        return headers;
    }

    /*
     * Prepare HTTP Headers.
     */
    private static HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }
}
