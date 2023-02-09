package com.example.restservice.api.controller;

import com.example.restservice.api.model.Animal;
import com.example.restservice.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/animal")
public class AnimalController {

    @Autowired
    AnimalService animalService;

    @GetMapping("/")
    public ResponseEntity<Animal> getRandomDog() {
        try {
            return new ResponseEntity<>(animalService.download(), HttpStatus.OK);
        }
        catch (NullPointerException e){
            return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (IOException e) {
            return new ResponseEntity("Picture Download Failed", HttpStatus.OK);
        }
    }
//    https://www.codejava.net/frameworks/spring-boot/file-download-upload-rest-api-examples
//    https://stackoverflow.com/questions/16015548/how-to-send-multipart-form-data-request-using-postman
    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity fileUpload(@RequestParam("file") MultipartFile file) {
        try {
            animalService.upload(file);
            return new ResponseEntity("Upload Successful", HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
