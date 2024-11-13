package com.example.backend.backend.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageService {

    @Value("${image.upload.dir}") 
    private static String uploadDir;

    public static String saveImage(MultipartFile file) throws IOException {
        
        File directory = new File(uploadDir);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        
        String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get(uploadDir, fileName);
        
       
        Files.write(filePath, file.getBytes());

       
        return "/images/" + fileName; 
    }
}
