package com.onlineshop.notificationservice.service;

import com.onlineshop.notificationservice.model.NotificationModel;

public interface NotificationService {
    public NotificationModel create(NotificationModel notificationModel);
    public NotificationModel update(String id, NotificationModel notificationModel);
    public NotificationModel getById(String id);
    public Boolean delete(String id);
}
