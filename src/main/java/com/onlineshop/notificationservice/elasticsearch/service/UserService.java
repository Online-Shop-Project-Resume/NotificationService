package com.onlineshop.notificationservice.elasticsearch.service;

import com.onlineshop.notificationservice.elasticsearch.dto.UserDto;
import com.onlineshop.notificationservice.elasticsearch.repository.UserRepository;
import com.onlineshop.notificationservice.exception.ElasticsearchNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto getById(String userId){
        String id = userId;
        //pattern for PK in elasticsearch for users index
        userId= "{\"id\":\""+userId+"\"}";
        log.info("Elastic User exists by id: {}", userId);
        return userRepository.findById(userId).orElseThrow(()-> new ElasticsearchNotFoundException("User with id: "+ id + " not found"));
    }
}
