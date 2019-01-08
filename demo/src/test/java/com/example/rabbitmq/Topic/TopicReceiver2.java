package com.example.rabbitmq.Topic;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * ClassName: TopicReceiver
 * Description: TODO
 * Author Lu.Mrs
 * Date: 2019/1/7下午 3:37
 * Version: 1.0
 */
@Component
@RabbitListener(queues = "topic.#")
public class TopicReceiver2 {
    @RabbitHandler
    public void process(String message) {
        System.out.println("Topic Receiver2  : " + message);
    }
}
