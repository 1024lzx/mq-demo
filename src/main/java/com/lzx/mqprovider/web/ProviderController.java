package com.lzx.mqprovider.web;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProviderController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping
    public void convertAndSend(@RequestParam("message") String message) {
        amqpTemplate.convertAndSend("com.queue.notify.hello", message);
    }
}
