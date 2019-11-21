package com.jimmy.cloud.rabbitmq.controller;

import com.jimmy.cloud.rabbitmq.service.RabbitSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;


@RestController
@Slf4j
public class RabbitmqController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private RabbitSender rabbitSender;

    /**
     * @Description: 发送消息
     * 1.交换机
     * 2.key
     * 3.消息
     * 4.消息ID
     * rabbitTemplate.send(message);   发消息;参数对象为org.springframework.amqp.core.Message
     * rabbitTemplate.convertAndSend(message); 转换并发送消息;将参数对象转换为org.springframework.amqp.core.Message后发送,消费者不能有返回值
     * rabbitTemplate.convertSendAndReceive(message) //转换并发送消息,且等待消息者返回响应消息.消费者可以有返回值
     * @method: handleMessage
     * @Param: message
     * @return: void
     * @auther: LHL
     * @Date: 2018/11/18 21:40
     */
    @GetMapping("/directSend/{msg}")
    public void directSend(@PathVariable("msg") String msg) {
        rabbitSender.sendMessage("DirectExchange", "DirectKey", msg);
    }

    @GetMapping("/topicSend")
    public void topicSend() {
        String message="topic 发送消息";
        rabbitSender.sendMessage("TopicExchange", "Topic.Key", message);
    }

    @GetMapping("/fanoutSend")
    public void fanoutSend() {
        String message="fanout 发送消息";
        rabbitSender.sendMessage("FanoutExchange", "", message);
    }

    @GetMapping("/headersSend")
    public void headersSend(){
        String msg="headers 发送消息";
        MessageProperties properties = new MessageProperties();
        properties.setHeader("headers1","value1");
        properties.setHeader("headers2","value2");
        Message message = new Message(msg.getBytes(),properties);
        rabbitSender.sendMessage("HeadersExchange", "", message);
    }
}
