package com.microservices.school;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class FullSchoolResponse {
    private School school;
    private List<Student> students;
}
