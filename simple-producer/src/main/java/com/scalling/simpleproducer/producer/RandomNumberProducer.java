package com.scalling.simpleproducer.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
@RequiredArgsConstructor
public class RandomNumberProducer {

    /*KafkaTemplate немного похож на JdbcTemplate для взаимодействия с базой данных,
    только KafkaTemplate предоставляет верхне-уровневые операции для работы брокером Kafka.
    KafkaTemplate предоставляет "обертку" для Producer и Consumer, и
     предоставляет удобные методы для отправки данных в Topics Kafka.
     */
    private final KafkaTemplate<String, String> kafkaTemplate;

    private final AtomicInteger counter = new AtomicInteger(1);

    /*Сообщения будет генерироваться 1 раз в секунду*/
    @Scheduled(fixedRate = 1000)
    public void produce() throws UnknownHostException {

        int sequenceNumber = counter.getAndIncrement();
        String message = String.valueOf(sequenceNumber);

        /*Отправка сообщения в Topic по умолчанию, которую мы определили в свойстве:
         * spring.kafka.template.default-topic*/
        this.kafkaTemplate.sendDefault(message);

        /*Этот блок кода для логгирования*/
        String hostName = InetAddress.getLocalHost().getHostName();
        log.info(String.format("%s produced : %d", hostName, sequenceNumber));
    }
}
