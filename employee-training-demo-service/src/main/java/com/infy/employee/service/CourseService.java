package com.infy.employee.service;


import com.infy.employee.domain.request.CourseCreateRequest;
import com.infy.employee.entity.Course;
import com.infy.employee.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CourseService {

    @Autowired
    public CourseRepository courseRepository;

    public Course getCourseById(String id){
        return courseRepository.findOne(UUID.fromString(id));
    }

    public Course saveCourse(CourseCreateRequest course){
        return courseRepository.save(Course.builder().courseName(course.getCourseName()).build());
    }
}
