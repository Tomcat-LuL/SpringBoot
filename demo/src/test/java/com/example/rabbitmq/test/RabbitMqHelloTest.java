package com.example.rabbitmq.test;

/**
 * ClassName: RabbitMqHelloTest
 * Description: TODO
 * Author Lu.Mrs
 * Date: 2019/1/4上午 10:23
 * Version: 1.0
 */

import com.example.rabbitmq.Fanout.FanoutSender;
import com.example.rabbitmq.OneToOne.HelloSender;
import com.example.rabbitmq.ManyToMany.HelloSenderOne;
import com.example.rabbitmq.ManyToMany.HelloSenderTwo;
import com.example.rabbitmq.Topic.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMqHelloTest {
    @Autowired
    private HelloSender helloSender;
    @Autowired
    private HelloSenderOne helloSenderOne;
    @Autowired
    private HelloSenderTwo helloSenderTwo;
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private FanoutSender fanoutSender;

    @Test
    public void hello() throws Exception {
        helloSender.send();
    }

    @Test
    public void helloOneToMany() throws Exception {
        for (int i=0;i<100;i++){
            helloSenderOne.sendOneToMany(i);
            helloSenderTwo.sendOneToMany2(i);
        }
        Thread.sleep(1000l);
    }

    @Test
    public void topicTest() throws Exception {
        topicSender.send1();
        Thread.sleep(1000l);
    }
    @Test
    public void topic2() throws Exception {
        topicSender.send2();
        Thread.sleep(1000l);
    }

    @Test
    public void fanoutSender() throws Exception {
        fanoutSender.send();
        Thread.sleep(1000l);
    }
}
