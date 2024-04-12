package com.microservices.school;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository repository;
    private final StudentClient client;

    public void saveSchool(School school){
        repository.save(school);
    }

    public List<School> findAllSchools(){
        return repository.findAll();
    }

    public FullSchoolResponse findSchoolWithStudents(Integer schoolId) {
        School school = repository.findById(schoolId).orElseThrow(()-> new RuntimeException("School not found"));

        var students = client.findAllStudentBySchool(schoolId);

        return FullSchoolResponse.builder()
                .school(school)
                .students(students)
                .build();
    }
}
