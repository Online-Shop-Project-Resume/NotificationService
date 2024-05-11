package com.onlineshop.notificationservice.dto.dtoMapper;

import com.onlineshop.notificationservice.dto.request.NotificationDtoRequest;
import com.onlineshop.notificationservice.kafka.consumer.NotificationConsumer;
import com.onlineshop.notificationservice.model.NotificationModel;

public class NotificationConsumerMapper {
    public static NotificationModel toModel(NotificationConsumer notificationConsumer){
        NotificationModel notificationModel = new NotificationModel();
        notificationModel.setTitle(notificationConsumer.getTitle());
        notificationModel.setMessage(notificationConsumer.getMessage());
        notificationModel.setUserId(notificationConsumer.getUserId());

        return notificationModel;
    }
}
