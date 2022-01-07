package com.l2.challenge.controller;

import com.l2.challenge.dto.MessageDto;
import com.l2.challenge.service.MessageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    private MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping
    public MessageDto getMessage() {
        return messageService.getMessage();
    }
}
