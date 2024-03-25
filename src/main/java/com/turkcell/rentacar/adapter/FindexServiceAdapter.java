package com.turkcell.rentacar.adapter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class FindexServiceAdapter {
    private final RestTemplate restTemplate;
    public int getFindexScore(int customerId) {
        String url = "http://localhost:8080/findex/" + customerId;
        return restTemplate.getForObject(url, Integer.class);
    }
}
