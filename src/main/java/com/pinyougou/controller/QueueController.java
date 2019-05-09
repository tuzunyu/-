package com.pinyougou.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
@RestController
public class QueueController {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @RequestMapping("/sendsms")
    public void sendSms(){

        Map map=new HashMap<>();
        map.put("mobile", "18380256876");
        map.put("template_code", "SMS_164085396");
        map.put("sign_name", "大耳朵图图");
        map.put("param", "{\"code\":\"5201314\"}");
        jmsMessagingTemplate.convertAndSend("sms",map);
    }
}
