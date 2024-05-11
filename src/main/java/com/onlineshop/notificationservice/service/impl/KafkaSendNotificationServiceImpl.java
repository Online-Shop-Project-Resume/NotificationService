package com.onlineshop.notificationservice.service.impl;

import com.onlineshop.notificationservice.service.KafkaSendNotificationService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaSendNotificationServiceImpl implements KafkaSendNotificationService {

    @Override
    @KafkaListener(topics = "${spring.kafka.wishlist-notification-added-product-topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void notificationAddedProduct(Long whishlistProductId) {

    }
}
