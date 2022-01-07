package com.l2.challenge.client;

import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class FoaasClient {

    public String getMessage() {
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.TEXT_PLAIN));
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = "https://foaas.com/family/lucas";

        ResponseEntity<String> response
                = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if(!(response.getStatusCode() == HttpStatus.OK)){
                throw new RuntimeException("Client Error");
        }
        return response.getBody();
    }
}
