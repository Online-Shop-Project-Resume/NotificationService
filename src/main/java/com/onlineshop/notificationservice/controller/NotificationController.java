package com.onlineshop.notificationservice.controller;

import com.onlineshop.notificationservice.dto.dtoMapper.NotificationDtoMapper;
import com.onlineshop.notificationservice.dto.request.NotificationDtoRequest;
import com.onlineshop.notificationservice.dto.response.NotificationDtoResponse;
import com.onlineshop.notificationservice.model.NotificationModel;
import com.onlineshop.notificationservice.service.impl.NotificationServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/notification")
@Tag(name = "Notification Controller", description = "Operations related to saving notification tto database")
public class NotificationController {
    private final NotificationServiceImpl notificationService;

    public NotificationController(NotificationServiceImpl notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Notification by Id", description = "Get Notification by Id")
    @ApiResponse(responseCode = "200", description = "Get Notification successfully")
    @ApiResponse(responseCode = "404", description = "Notification with such an Id is not found")
    public ResponseEntity<NotificationDtoResponse> getById(@PathVariable("id") String id){
        NotificationModel model = notificationService.getById(id);
        return new ResponseEntity<>(NotificationDtoMapper.toResponse(model), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Notification by Id", description = "Update Notification by Id and new Notification Object")
    @ApiResponse(responseCode = "201", description = "Update Notification successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @ApiResponse(responseCode = "404", description = "Notification with such an Id is not found")
    public ResponseEntity<NotificationDtoResponse> updateById(@PathVariable("id") String id,
                                                              @Valid @RequestBody NotificationDtoRequest request){
        NotificationModel model = NotificationDtoMapper.toModel(request);
        model = notificationService.update(id, model);
        return new ResponseEntity<>(NotificationDtoMapper.toResponse(model), HttpStatus.CREATED);
    }

    @PostMapping
    @Operation(summary = "Create Notification", description = "Create new record of Notification into a database")
    @ApiResponse(responseCode = "201", description = "Create Notification successfully")
    @ApiResponse(responseCode = "400", description = "Invalid input")
    @ApiResponse(responseCode = "404", description = "Foreign key is not found")
    public ResponseEntity<NotificationDtoResponse> create(@Valid @RequestBody NotificationDtoRequest request){
        NotificationModel model = NotificationDtoMapper.toModel(request);
        model = notificationService.create(model);
        return new ResponseEntity<>(NotificationDtoMapper.toResponse(model), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiResponse(responseCode = "204", description = "Delete Notification successfully")
    @ApiResponse(responseCode = "404", description = "Notification with such an Id is not found")
    public ResponseEntity<Boolean> delete(@PathVariable("id") String id){
        return new ResponseEntity<>(notificationService.delete(id), HttpStatus.CREATED);
    }
}
