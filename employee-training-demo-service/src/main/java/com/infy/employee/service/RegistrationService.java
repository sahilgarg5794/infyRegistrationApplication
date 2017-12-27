package com.infy.employee.service;

import com.infy.employee.entity.Course;
import com.infy.employee.entity.Registration;
import com.infy.employee.repository.CourseRepository;
import com.infy.employee.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;
    @Autowired
    private CourseRepository courseRepository;

    public Registration findByCourse(UUID courseId){
        Course course = courseRepository.findOne(courseId);
        return registrationRepository.findByCourse(course);
    }
}
