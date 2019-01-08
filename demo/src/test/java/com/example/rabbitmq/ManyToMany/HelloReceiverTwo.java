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
public class HelloReceiverTwo {
    @RabbitHandler
    public void process2(String helloOne) {
        System.out.println("ReceiverTwo : " + helloOne);
    }
}
