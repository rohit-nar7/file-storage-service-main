package com.javatechie.controller;

import com.javatechie.entity.ImageData;
import com.javatechie.respository.StorageRepository;
import com.javatechie.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
public class StorageController {

    private StorageService storageService;
    @Autowired
    private StorageRepository storageRepository;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping
    public void saveImage(@RequestParam("image") MultipartFile image) throws Exception {
        try {
            ImageData img = new ImageData();
            img.setName(image.getOriginalFilename());
            img.setType(image.getContentType());
            img.setImageData(image.getBytes());
            storageService.saveImage(img);
        } catch (IOException e) {
            // handle exception
            throw new Exception("error while saving file");
        }
    }

    @GetMapping("get")
    public ResponseEntity<?> getAllEvent() {
        return new ResponseEntity<>(storageRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("push")
    public ResponseEntity<Void> saveEvent(@RequestParam("eventId") String eventId,
                                          @RequestParam("email") String email,
                                          @RequestParam("name") String name,
                                          @RequestParam("type") String type,
                                          @RequestParam("totalSeat") int totalSeat,
                                          @RequestParam("image") MultipartFile image) {
        try {
            ImageData event = new ImageData();
            event.setEventId(eventId);
            event.setEmail(email);
            event.setName(name);
            event.setType(type);
            event.setTotalSeat(totalSeat);
            event.setImageData(image.getBytes());
            storageService.saveImage(event);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            // Handle exception
        }
        return null;
    }
}














