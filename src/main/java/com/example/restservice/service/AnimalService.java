package com.example.restservice.service;

import com.example.restservice.adapter.AnimalAdapter;
import com.example.restservice.api.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class AnimalService {
    @Autowired
    private AnimalAdapter animalAdapter;

    public Animal download() throws IOException {
        Animal animal = animalAdapter.getRandomAnimal();
        if(animal == null) {
            throw new NullPointerException("animal not found");
        }
        else {
            String urlAsString = animal.getMessage();
            String[] urlAsArray = urlAsString.split("/");
            URL url = new URL(animal.getMessage());
            InputStream in = url.openStream();
            String path = "src\\main\\resources\\download\\" + urlAsArray[urlAsArray.length-1];
            Files.copy(in, Paths.get(path));
        }
        return animal;
    }

    public void upload(MultipartFile file) throws IOException {
        File convertFile = new File("src\\main\\resources\\upload\\"+file.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
    }
}
