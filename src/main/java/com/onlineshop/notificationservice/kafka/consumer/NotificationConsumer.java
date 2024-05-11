package com.onlineshop.notificationservice.kafka.consumer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationConsumer {
    private String title;
    private String message;
    private String userId;
}
