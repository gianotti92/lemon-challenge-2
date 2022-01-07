package com.l2.challenge.service;

import com.l2.challenge.client.FoaasClient;
import com.l2.challenge.dto.MessageDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class MessageService {
    private FoaasClient foaasClient;

    public MessageService(FoaasClient foaasClient) {
        this.foaasClient = foaasClient;
    }

    @Cacheable("message")
    public MessageDto getMessage() {
        return new MessageDto(foaasClient.getMessage());
    }
}
