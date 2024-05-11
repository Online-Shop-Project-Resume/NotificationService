package com.onlineshop.notificationservice.service.impl;

import com.onlineshop.notificationservice.dto.dtoMapper.NotificationConsumerMapper;
import com.onlineshop.notificationservice.exception.MongoNotFoundException;
import com.onlineshop.notificationservice.kafka.consumer.NotificationConsumer;
import com.onlineshop.notificationservice.model.NotificationModel;
import com.onlineshop.notificationservice.repository.NotificationRepository;
import com.onlineshop.notificationservice.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final EmailSenderServiceImp emailSenderService;

    public NotificationServiceImpl(NotificationRepository notificationRepository, EmailSenderServiceImp emailSenderService) {
        this.notificationRepository = notificationRepository;
        this.emailSenderService = emailSenderService;
    }

    @Override
    public NotificationModel create(NotificationModel notificationModel) {
        log.info("Notification create: {}", notificationModel);
        notificationModel.setIsRead("N");
        return notificationRepository.save(notificationModel);
    }

    @Override
    public NotificationModel update(String id, NotificationModel notificationModel) {
        log.info("Notification update: {}", notificationModel);
        NotificationModel updatedNotificationModel = getById(id);
        updatedNotificationModel.setTitle(notificationModel.getTitle());
        updatedNotificationModel.setMessage(notificationModel.getMessage());
        updatedNotificationModel.setUserId(notificationModel.getUserId());
        return updatedNotificationModel;
    }

    @Override
    public NotificationModel getById(String id) {
        log.info("Notification get by id: {}", id);
        return notificationRepository.findById(id).orElseThrow(()-> new MongoNotFoundException("Notification with id: "+id+"is not found"));
    }

    @Override
    public Boolean delete(String id) {
        log.info("Notification delete by id: {}", id);
        notificationRepository.deleteById(id);
        return true;
    }


}
