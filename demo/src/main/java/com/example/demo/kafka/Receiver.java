package com.example.demo.kafka;

import java.util.concurrent.CountDownLatch;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

  private CountDownLatch latch = new CountDownLatch(1);

  public CountDownLatch getLatch() {
    return latch;
  }

  @KafkaListener(topics = "bet_detail")
  public void receive(ConsumerRecord<?, ?> consumerRecord) {
    if (Double.valueOf(consumerRecord.value().toString()) >= 1500) {
      LOGGER.info("RETURNS value is equal or greater to 1500");
    }
  }
}