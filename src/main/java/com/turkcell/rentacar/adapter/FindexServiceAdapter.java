package com.turkcell.rentacar.adapter;

import com.turkcell.rentacar.entities.concretes.Customer;
import com.turkcell.rentacar.entities.concretes.IndividualCustomer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class FindexServiceAdapter implements FindexService{
    private RestTemplate restTemplate;     //RestTemplate Http protokolunu kullanarak Rest istekleri göndermemizi sağlıyor.
    public int getFindexScoreofCustomer(int customerId) {
        String url = "http://localhost:8080/findex/" + customerId;
        return this.restTemplate.getForObject(url, Integer.class); //Todo Burası düzelecek Integer.class nesne olarak dönderecez.
    }
}
