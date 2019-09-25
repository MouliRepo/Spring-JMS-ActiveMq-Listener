package com.NTT.entity;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "TBL_MESSAGE_QUEUE")
public class MessageQueueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Basic()
    @Column(name = "queue_name", length = 20)
    private String queueName;

    @Basic()
    @Column(name = "queue_message", length = 250)
    private String queueMessage;

    @Basic()
    @Column(name = "created_date", length = 20)
    private Timestamp createDate;

    @Basic()
    @Column(name = "receive_message", length = 1)
    private String receiveMessage;

    @Basic()
    @Column(name = "created_by", length = 50)
    private String createdBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQueueName() {
        return queueName;
    }

    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public String getQueueMessage() {
        return queueMessage;
    }

    public void setQueueMessage(String queueMessage) {
        this.queueMessage = queueMessage;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }
    public String getReceiveMessage() {
        return receiveMessage;
    }

    public void setReceiveMessage(String receiveMessage) {
        this.receiveMessage = receiveMessage;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }


}
