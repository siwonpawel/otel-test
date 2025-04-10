package com.github.siwonpawel.otel;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class ClientSimulator
{

    private final RestTemplate restTemplate;

    @Scheduled(cron = "*/1 * * * * *")
    public void callHelloWorld()
    {
        String response = restTemplate.getForObject("http://localhost:8080/hello", String.class);

        log.info("Response: {}", response);
    }

}