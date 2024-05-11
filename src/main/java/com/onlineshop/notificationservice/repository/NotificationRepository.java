package com.onlineshop.notificationservice.repository;

import com.onlineshop.notificationservice.model.NotificationModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<NotificationModel, String> {
}
