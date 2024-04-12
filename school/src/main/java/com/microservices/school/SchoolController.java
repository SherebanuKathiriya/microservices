package com.microservices.school;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/schools")
public class SchoolController {
    private final SchoolService schoolService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveSchool(@RequestBody School school){
        schoolService.saveSchool(school);
    }

    @GetMapping
    public ResponseEntity<List<School>> getSchool(){
        List<School> result = schoolService.findAllSchools();
        return ResponseEntity.ok(result);
    }

    @GetMapping("with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findSchoolWithStudents(
            @PathVariable("school-id") Integer schoolId
    ){
        FullSchoolResponse result = schoolService.findSchoolWithStudents(schoolId);
        return ResponseEntity.ok(result);
    }


}
