package com.example.backend.backend.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.backend.backend.model.CourseAfter10;
import com.example.backend.backend.model.CourseAfter12;
import com.example.backend.backend.model.CoursesAfterUg;
import com.example.backend.backend.model.Exams;
import com.example.backend.backend.model.Internship;
import com.example.backend.backend.model.Schools;
import com.example.backend.backend.model.Webinar;
import com.example.backend.backend.repository.CourseAfter10Repository;
import com.example.backend.backend.repository.CoursesAfter12Repository;
import com.example.backend.backend.repository.CoursesAfterUgRepository;
import com.example.backend.backend.repository.ExamsRepository;
import com.example.backend.backend.repository.InternshipRepository;
import com.example.backend.backend.repository.SchoolRepository;
import com.example.backend.backend.service.ImageService;
import com.example.backend.backend.service.WebinarService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/api/edunav")
@CrossOrigin(origins = "http://localhost:5173")
public class ApiController {

    @Autowired
    private InternshipRepository internshipRepository;

    @Autowired
    private CourseAfter10Repository courseAfter10Repository;

    @Autowired
    private CoursesAfter12Repository coursesAfter12Repository;

    @Autowired
    private CoursesAfterUgRepository coursesAfterUgRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private ExamsRepository examsRepository;

    @Autowired
    private WebinarService webinarService;

    @GetMapping("/getInternships")
    public List<Internship> getInternships(){
        return internshipRepository.findAll();
    }

    @GetMapping("/GetCoursesAfter10")
    public List<CourseAfter10> getCoursesAfter10(){
        return courseAfter10Repository.findAll();
    }

    @GetMapping("/GetCoursesAfter12")
    public List<CourseAfter12> getCoursesAfter12(){
        return coursesAfter12Repository.findAll();
    }

    @GetMapping("/GetCoursesPG")
    public List<CoursesAfterUg> getCoursesAfterUg(){
        return coursesAfterUgRepository.findAll();
    }

    @GetMapping("/GetschoolsList")
    public List<Schools> getSchools(){
        return schoolRepository.findAll();
    }

    @GetMapping("/GetExams")
    public List<Exams> getExams(){
        return examsRepository.findAll();
    }


    @Value("${image.upload.dir}")
private String imageUploadDir;

@PostMapping("/upload-webinar")
public ResponseEntity<String> uploadWebinar(@RequestParam("name") String name,
                                            @RequestParam("topic") String topic,
                                            @RequestParam("date") String date,
                                            @RequestParam("time") String time,
                                            @RequestParam("image") MultipartFile image,
                                            @RequestParam("url") String url) {
    // Create a new Webinar object
    Webinar webinar = new Webinar();
    webinar.setName(name);
    webinar.setTopic(topic);
    webinar.setDate(date);
    webinar.setTime(time);
    webinar.setUrl(url);
    
    // Save the image and get the filename
    if (!image.isEmpty()) {
        try {
            // Create the directory if it doesn't exist
            Path directoryPath = Paths.get(imageUploadDir);
            Files.createDirectories(directoryPath); // Ensure the directory exists

            // Define the path where images will be saved
            Path path = directoryPath.resolve(image.getOriginalFilename());

            // Log the path being written to
            System.out.println("Saving image to: " + path.toString());

            // Save the image file
            Files.write(path, image.getBytes());
            // Set the image filename in the webinar object
            webinar.setImage(image.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to save image: " + e.getMessage());
        }
    } else {
        return ResponseEntity.badRequest().body("Image file is empty");
    }

    // Save the webinar details to the database
    webinarService.saveWebinar(webinar);
    
    return ResponseEntity.ok("Webinar details uploaded");
}



    @GetMapping("/get-webinars")
    public List<Webinar> getWebinars(){
        return webinarService.getAllWebinars();
    }
    
}
