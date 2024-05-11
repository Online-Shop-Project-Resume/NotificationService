package com.onlineshop.notificationservice.controller;

import com.onlineshop.notificationservice.service.impl.EmailSenderServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/email")
@Tag(name = "Email Sender", description = "Operations related to sending emails")
public class EmailSenderController {

    private final EmailSenderServiceImp emailService;

    @Autowired
    public EmailSenderController(EmailSenderServiceImp emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    @Operation(summary = "Send an email", description = "Send an email with attachments")
    @ApiResponse(responseCode = "200", description = "Email sent successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    public Boolean sendMail(
            @RequestParam(value = "file", required = false) @Parameter(description = "File") MultipartFile[] file,
            @RequestParam(value = "to") @Parameter(description = "Recipient's email address") String to,
            @RequestParam(value = "cc", required = false) @Parameter(description = "CC recipients' email addresses") String[] cc,
            @RequestParam(value = "subject") @Parameter(description = "Email subject") String subject,
            @RequestParam(value = "body") @Parameter(description = "Email body") String body
    ) {
        return emailService.sendMail(file, to, cc, subject, body);
    }
}
