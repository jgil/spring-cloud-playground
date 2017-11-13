package com.everis.micro.client;

import com.everis.micro.domain.Context;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class StepClient {

    @Autowired
    RestTemplate restTemplate;

    public Context step(String name, Context c) throws URISyntaxException {
        URI url = new URI("http://" + name + "/step");

        RequestEntity<Context> requestEntity = new RequestEntity<>(c, HttpMethod.POST, url);
        ResponseEntity<Context> responseEntity = restTemplate.exchange(requestEntity, Context.class);
        return responseEntity.getBody();
    }
}
