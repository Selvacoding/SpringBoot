package com.restful.restful.school;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public School toSchool(SchoolDto schooldto) {
        var school = new School();
        school.setName(schooldto.name());
        return school;
    }

    public SchoolResponseDto toSchoolResponseDto(School school){
        return new SchoolResponseDto(school.getName());
    }
}
