package com.restful.restful.school;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class SchoolService {
    private final SchoolMapper schoolMapper;
    private final SchoolRepository schoolRepo;
    
    
    public SchoolService(SchoolRepository schoolRepo) {
        this.schoolMapper = new SchoolMapper();
        this.schoolRepo = schoolRepo;
    }

    public SchoolResponseDto createSchool(SchoolDto schooldto) {
        var school = schoolMapper.toSchool(schooldto);
        var savedSchool = schoolRepo.save(school);
        return schoolMapper.toSchoolResponseDto(savedSchool);
    }


    public List<SchoolResponseDto> getSchool() {
        List<School> schools = schoolRepo.findAll();
            return schools.stream()
                .map(schoolMapper::toSchoolResponseDto)
                .collect(Collectors.toList());
    }

}
