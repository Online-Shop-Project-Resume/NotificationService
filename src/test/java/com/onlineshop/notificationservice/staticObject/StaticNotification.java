package com.onlineshop.notificationservice.staticObject;

import com.onlineshop.notificationservice.dto.request.NotificationDtoRequest;
import com.onlineshop.notificationservice.dto.response.NotificationDtoResponse;
import com.onlineshop.notificationservice.model.NotificationModel;
import java.time.LocalDateTime;

public class StaticNotification {

    public static final String ID = "id";

    public static NotificationModel notification1() {
        NotificationModel model = new NotificationModel();
        model.setId("id");
        model.setTitle("title");
        model.setMessage("message");
        model.setUserId("userId");
        model.setSentAt(LocalDateTime.MIN);
        model.setIsRead("isRead");
        return model;
    }

    public static NotificationDtoRequest notificationDtoRequest1() {
        NotificationDtoRequest dtoRequest = new NotificationDtoRequest();
        dtoRequest.setTitle("title");
        dtoRequest.setMessage("message");
        dtoRequest.setUserId("userId");
        return dtoRequest;
    }

    public static NotificationDtoResponse notificationDtoResponse1() {
        NotificationDtoResponse dtoResponse = new NotificationDtoResponse();
        dtoResponse.setId("id");
        dtoResponse.setTitle("title");
        dtoResponse.setMessage("message");
        dtoResponse.setUserId("userId");
        dtoResponse.setSentAt(LocalDateTime.MIN);
        dtoResponse.setIsRead("isRead");
        return dtoResponse;
    }


}
