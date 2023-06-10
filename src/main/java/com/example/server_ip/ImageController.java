package com.example.server_ip;

import java.io.File;
import java.io.IOException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;



@RestController
@RequestMapping("/api")
public class ImageController {


    @GetMapping("/image")
    public ResponseEntity<byte[]> getImage() throws  IOException{
        File file=new File("background_menu.png");
        byte[] imageBytes = Files.readAllBytes(file.toPath());
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }
}
