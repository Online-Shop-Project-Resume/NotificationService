package com.onlineshop.notificationservice.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("Notifications")
public class NotificationModel {
    @Id
    @Field(name = "notification_id")
    private String id;

    @Field(name = "title")
    private String title;

    @Field(name = "message")
    private String message;

    @Field(name = "userId")
    @Indexed
    private String userId;

    @CreatedDate
    @Field(name = "sent_at")
    private LocalDateTime sentAt;

    @Field(name = "is_read")
    private String isRead;

}
