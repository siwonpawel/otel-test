package com.github.siwonpawel.otel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class HelloWorldController
{

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hello")
    String helloWorld()
    {
        long counterValue = counter.incrementAndGet();

        log.info("Hello World #{}", counterValue);
        return "Hello World #%d".formatted(counterValue);
    }

}
