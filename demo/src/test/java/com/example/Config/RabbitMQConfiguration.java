package com.example.Config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName: RabbitMQConfiguration
 * Description: TODO
 * Author Lu.Mrs
 * Date: 2019/1/4上午 10:14
 * Version: 1.0
 */
@Configuration
public class RabbitMQConfiguration {
    @Bean
    public Queue Queue() {
        return new Queue("hello");
    }
}
