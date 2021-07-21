package com.demo.mykine.springtxjpa.service.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsumerService {

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * JmsListener监听回调的的方法，Session作用整个方法体，异常回自动回滚，默认重试操作
     * */
    @JmsListener(destination = "user:msg1")
    public void handleMsg1(String msg1){
        log.info("接收到消息:{}",msg1);
        log.info("处理消息中。。。");
        jmsTemplate.convertAndSend("user:msg2",msg1+"处理完毕～");
        log.info("msg2消息已发送～");
        if(msg1.contains("error")){
            throw new RuntimeException("消息处理过程中发生异常");
        }
        log.info("处理完毕！");
    }

    @JmsListener(destination = "user:msg2")
    public void handleMsg2(String msg2){
        log.info("接收到消息msg2:{}",msg2);
    }
}
