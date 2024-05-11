package com.onlineshop.notificationservice.dto.dtoMapper;

import com.onlineshop.notificationservice.dto.request.NotificationDtoRequest;
import com.onlineshop.notificationservice.dto.response.NotificationDtoResponse;
import com.onlineshop.notificationservice.model.NotificationModel;

public class NotificationDtoMapper {
    public static NotificationModel toModel(NotificationDtoRequest notificationRequest){
        NotificationModel notificationModel = new NotificationModel();
        notificationModel.setTitle(notificationRequest.getTitle());
        notificationModel.setMessage(notificationRequest.getMessage());
        notificationModel.setUserId(notificationRequest.getUserId());

        return notificationModel;
    }

    public static NotificationDtoResponse toResponse(NotificationModel notificationModel){
        NotificationDtoResponse response = new NotificationDtoResponse();
        response.setId(notificationModel.getId());
        response.setTitle(notificationModel.getTitle());
        response.setMessage(notificationModel.getMessage());
        response.setUserId(notificationModel.getUserId());
        response.setSentAt(notificationModel.getSentAt());
        response.setIsRead(notificationModel.getIsRead());

        return response;
    }
}
