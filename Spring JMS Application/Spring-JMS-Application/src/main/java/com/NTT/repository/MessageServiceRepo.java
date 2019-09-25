package com.NTT.repository;

import com.NTT.entity.MessageQueueEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageServiceRepo extends JpaRepository<MessageQueueEntity,Long> {
}
