package com.NTT.message;

import com.NTT.vo.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;

public class OrderSender {

  @Value("${queue}")
  private String queueName;

  private static final Logger LOGGER =
      LoggerFactory.getLogger(OrderSender.class);

  @Autowired
  private JmsTemplate jmsTemplate;

  public void send(String product) {
    LOGGER.info("sending message='{}'", product);
    jmsTemplate.convertAndSend(queueName, product);
  }
}
