package com.demo.mykine.springtxjpa.controller;

import com.demo.mykine.springtxjpa.dao.User.TUsersMapper;
import com.demo.mykine.springtxjpa.domain.entity.User.TUsers;
import com.demo.mykine.springtxjpa.service.UserService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping("/test")
    public TUsers testInsert(){
        TUsers user = new TUsers();
        user.setAge(1);
        user.setName("james");
        user.setGender(1);
        try {
//            userService.addData(user);
            userService.addData2(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @GetMapping("/sendMsg")
    public String sendMsg(@RequestParam String msg){
        jmsTemplate.convertAndSend("user:msg1",msg);
        log.info("消息发送成功！msg={}",msg);
        return msg;
    }

    @GetMapping("/readMsg2")
    public String sendMsg(){
        jmsTemplate.setReceiveTimeout(2000);
        Object obj = jmsTemplate.receiveAndConvert("user:msg2");
        String msg = String.valueOf(obj);
        return msg;
    }
}
