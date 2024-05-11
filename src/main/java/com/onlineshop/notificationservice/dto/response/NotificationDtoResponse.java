package com.onlineshop.notificationservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationDtoResponse {
    private String id;

    private String title;

    private String message;

    private String userId;

    private LocalDateTime sentAt;

    private String isRead;
}
