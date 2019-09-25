package com.NTT.service;

import com.NTT.constant.CommonConstants;
import com.NTT.entity.MessageQueueEntity;
import com.NTT.repository.MessageServiceRepo;
import com.NTT.vo.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Timestamp;
import java.util.Date;

@Service
@Transactional
public class MessageService {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(MessageService.class);

    @Autowired
    MessageServiceRepo messageServiceRepo;

    @Value("${queue}")
    private String queueName;

    public void createOrupdate(Object product) throws Exception{
        LOGGER.info("createOrupdate ='{}'", product);
        MessageQueueEntity mqEntity = new MessageQueueEntity();
        mqEntity.setQueueMessage(product.toString());
        mqEntity.setReceiveMessage(CommonConstants.YES);
        mqEntity.setCreatedBy(CommonConstants.CREATED_BY);
        mqEntity.setCreateDate(this.getCurrentTimeStamp());
        mqEntity.setQueueName(queueName);
        messageServiceRepo.save(mqEntity);
    }

    public Timestamp getCurrentTimeStamp(){
        Date  currentDate= new Date();
        return new Timestamp(currentDate.getTime());
    }
}
