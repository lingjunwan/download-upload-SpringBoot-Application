package com.example.restservice.adapter;

import com.example.restservice.api.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AnimalAdapter {

    @Autowired
    private RestTemplate restTemplate;

    public Animal getRandomAnimal(){
        AnimalDTO dto = restTemplate.getForObject("https://dog.ceo/api/breeds/image/random", AnimalDTO.class);
        return Animal.builder().status(dto.getStatus()).message(dto.getMessage()).build();
    }
}
