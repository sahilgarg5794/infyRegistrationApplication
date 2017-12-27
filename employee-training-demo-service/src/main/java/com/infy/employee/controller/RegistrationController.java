package com.infy.employee.controller;

import com.infy.employee.entity.Registration;
import com.infy.employee.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@RepositoryRestController
@RequestMapping(value = "/registrations")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping(value = "findByCourse")
    public ResponseEntity<Registration> findByCourse(@RequestParam(name = "courseId")String courseId){
        Registration registration = registrationService.findByCourse(UUID.fromString(courseId));
        return new ResponseEntity<Registration>(registration, HttpStatus.OK);
    }
}
