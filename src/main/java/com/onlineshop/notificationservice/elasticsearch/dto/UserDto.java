package com.onlineshop.notificationservice.elasticsearch.dto;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "keycloak.public.user_entity")
public class UserDto {
    private String id;
    private String email;
}
