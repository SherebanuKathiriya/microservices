package com.microservices.student;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> result = studentService.findAllStudents();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/school/{school-id}")
    public ResponseEntity<List<Student>> getStudentsOfSchool(
            @PathVariable("school-id") Integer schoolId
    ){
        List<Student> result = studentService.findAllStudentsOfSchool(schoolId);
        return ResponseEntity.ok(result);
    }
}
