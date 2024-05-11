package com.onlineshop.notificationservice.elasticsearch.repository;


import com.onlineshop.notificationservice.elasticsearch.dto.UserDto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface UserRepository extends ElasticsearchRepository<UserDto, String> {
}
