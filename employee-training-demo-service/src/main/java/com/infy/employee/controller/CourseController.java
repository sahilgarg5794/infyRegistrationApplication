package com.infy.employee.controller;

import com.infy.employee.domain.request.CourseCreateRequest;
import com.infy.employee.entity.Course;
import com.infy.employee.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RepositoryRestController
@Api("Course Controller")
@RequestMapping(value = "/course")
public class CourseController {

    @Autowired
    private CourseService  courseService;

    @RequestMapping(value = "getCourse/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "get Course By Id")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "Success")})
    public ResponseEntity<Course> getCourseById(@PathVariable(value = "id") String id){
         Course course=courseService.getCourseById(id);
         return new ResponseEntity<Course>(course, HttpStatus.OK);
    }

    @RequestMapping(value = "saveCourse",method = RequestMethod.POST)
    @ApiOperation(value = "save Course")
    @ApiResponses(value = {@ApiResponse(code = 201,message = "Created")})
    public ResponseEntity<Course> CreateCourse(@RequestBody CourseCreateRequest course){
        Course course1=courseService.saveCourse(course);
        return new ResponseEntity<Course>(course1, HttpStatus.OK);
    }


}
