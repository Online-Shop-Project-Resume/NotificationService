package com.onlineshop.notificationservice.service;

import org.springframework.web.multipart.MultipartFile;

public interface EmailService {
    Boolean sendMail(MultipartFile[] file, String to, String[] cc, String subject, String body);
}
