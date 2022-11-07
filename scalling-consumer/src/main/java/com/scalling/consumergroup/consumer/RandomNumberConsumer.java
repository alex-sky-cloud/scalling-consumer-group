package com.scalling.consumergroup.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Component
@Slf4j
public class RandomNumberConsumer {

    @Value("${message.processing.time}")
    private long processingTime;

    @KafkaListener(topics = "random-number")
    public void consumer(String message) throws UnknownHostException, InterruptedException {

        String hostName = InetAddress.getLocalHost().getHostName();
        log.info(String.format("%s consumed : %s", hostName, message));

        /*имтитация того, что Consumer не успевает обрабатывать
        поступающие в брокер сообщения */
        Thread.sleep(processingTime);
    }
}
