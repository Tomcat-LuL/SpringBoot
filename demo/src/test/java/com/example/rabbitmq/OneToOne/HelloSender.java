package com.example.rabbitmq.OneToOne;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ClassName: HelloSender
 * Description: 发送者
 * Author Lu.Mrs
 * Date: 2019/1/4上午 10:20
 * Version: 1.0
 */
@Component
public class HelloSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        this.rabbitTemplate.convertAndSend("hello", context);
    }

    public void sendOneToMany(int i) {
        String context = "helloOne " + "-------"+i;
        System.out.println("SenderOne : " + context);
        this.rabbitTemplate.convertAndSend("helloOne", context);
    }
    public void sendOneToMany2(int i) {
        String context = "helloOne2 " + "-------"+i;
        System.out.println("SenderOne2 : " + context);
        this.rabbitTemplate.convertAndSend("helloOne", context);
    }

}
