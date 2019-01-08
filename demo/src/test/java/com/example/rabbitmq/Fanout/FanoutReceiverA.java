package com.example.rabbitmq.Fanout;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: FanoutReceiverA
 * Description: TODO
 * Author Lu.Mrs
 * Date: 2019/1/7下午 4:49
 * Version: 1.0
 */
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {
    @RabbitHandler
    public void process(String message) {
        System.out.println("fanout Receiver A: " + message);
    }
}
