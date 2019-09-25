package com.NTT.message;

import java.util.concurrent.CountDownLatch;

import com.NTT.Exception.ApplicationException;
import com.NTT.constant.CommonConstants;
import com.NTT.service.MessageService;
import com.NTT.vo.Product;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;

import javax.jms.Message;

public class OrderReceiver {

  private static final Logger LOGGER =
      LoggerFactory.getLogger(OrderReceiver.class);

  @Autowired
  JmsTemplate jmsTemplate;
  @Autowired
  MessageConverter messageConverter;
     @Autowired
    MessageService service;


public String receiveMessage()
{
  try
  {
    /*
     * Here we receive the message.
     */
      Message message = jmsTemplate.receive();
      Object response = messageConverter.fromMessage(message);
      LOGGER.info("received message='{}'", response.toString());
      if(response!=null){
        service.createOrupdate(response);
        return CommonConstants.SUCCESS;
      }
    }
    catch (Exception exe)
    {
      exe.printStackTrace();
    }
    return null;
  }

}
