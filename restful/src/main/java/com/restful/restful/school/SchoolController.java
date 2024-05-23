package com.restful.restful.school;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }


    @PostMapping("/schools")
    public SchoolResponseDto createSchool(@RequestBody SchoolDto schooldto) {
        return schoolService.createSchool(schooldto);
    }
    

    @GetMapping("/schools")
    public List<SchoolResponseDto> getSchool() {
        return schoolService.getSchool();
    }
}
