package com.onlineshop.notificationservice.service;

public interface KafkaSendNotificationService {
    void notificationAddedProduct(Long whishlistProductId);
}
