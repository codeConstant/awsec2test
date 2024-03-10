package com.aws.ec2.deploy.controller;

import com.aws.ec2.deploy.opaque.WeatherRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URI;

@RestController
public class ApiController {

    @Value("${server.port}")
    private int serverPort;
    @GetMapping("hello")
    public String hello() {
        return "Hello, I am being printed from ec2 ..." + serverPort;
    }

    @PostMapping("weather-forecast")
    public Mono<Object> weather(@RequestBody
                                WeatherRequest weatherRequest) {

        var baseUri = URI.create("https://weather.visualcrossing.com/");

        var key = "JCGWDFFVA4VAUGZJQK6XALFXB";

        var requestString = weatherRequest.getLocation().concat("/" + weatherRequest.getPeriod());


        var absoluteUri = baseUri.resolve("VisualCrossingWebServices/rest/services/timeline/"
                + requestString +
                "?unitGroup=metric&key="+ key+ "&contentType=json");

        return WebClient.builder()
                .build()
                .get()
                .uri(absoluteUri)
                .retrieve()
                .bodyToMono(Object.class)
                .flatMap(Mono::just);
    }

}
