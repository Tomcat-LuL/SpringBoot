package com.example.rabbitmq.ManyToMany;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: HelloReceiver
 * Description: TODO
 * Author Lu.Mrs
 * Date: 2019/1/4上午 10:21
 * Version: 1.0
 */
@Component
@RabbitListener(queues = "helloOne")
public class HelloReceiverOne {
    @RabbitHandler
    public void process(String helloOne) {
        System.out.println("ReceiverOne : " + helloOne);
    }
}
