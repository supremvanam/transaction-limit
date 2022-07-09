package com.sv.customerlimits.client;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api/limits/test")
public class TransactionLimitClient {

    WebClient webClient;

    @PostConstruct
    public void init() {
        webClient = WebClient.builder().baseUrl("http://localhost:8081/api/limits").defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
    }

    @GetMapping
    public Mono<String> getTransactionLimits() {
        System.out.println("In the Transaction Limit Client class");
        return webClient.get().retrieve().bodyToMono(String.class);
    }

    @GetMapping("/{id}")
    public Mono<String> getTransactionLimitsById(@PathVariable("id") Long id) {
        System.out.println("In the Transaction Limit by ID Client class");
        return webClient.get().uri("/"+id).retrieve().bodyToMono(String.class);
    }

    @PostMapping
    public Mono<String> addNewTransactionLimit(@RequestBody TLModel limit) {
        return webClient
                .post()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .syncBody(limit)
                .retrieve()
                .bodyToMono(String.class);
    }
}
