package com.lzx.mqprovider.web;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AmqpServiceConsumer {

    @RabbitListener(queues = {"com.queue.notify.hello"})
    public void receiveSmsCodeQueue(String message) throws InterruptedException {
        System.out.println(message+"_1"+",currentThread:"+Thread.currentThread().getId());
    }
}
