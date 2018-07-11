package com.infy.employee.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infy.employee.domain.request.CourseCreateRequest;
import com.infy.employee.entity.Course;
import com.infy.employee.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import mockit.Expectations;
import mockit.Injectable;
import mockit.Tested;
import mockit.integration.junit4.JMockit;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.UUID;

@RunWith(JMockit.class)
@Slf4j
public class CourseControllerTest {
    @Injectable
    private CourseService courseService;

    @Tested
    private CourseController courseController;

    private MockMvc mockMvc;

    private ObjectMapper objectMapper;


    @Test
    public  void createCourseSuccessfully() throws Exception {
        this.mockMvc= MockMvcBuilders.standaloneSetup(courseController).build();
        CourseCreateRequest courseCreateRequest=getCourseCreateRequest();
        new Expectations(){{
            courseService.saveCourse((CourseCreateRequest) any);result= Course.builder().courseName("science").id(UUID.randomUUID()).build();
        }
        };
        this.mockMvc.perform(MockMvcRequestBuilders.post("/course/saveCourse").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(courseCreateRequest))).andExpect(MockMvcResultMatchers.status().isOk());

    }

    private CourseCreateRequest getCourseCreateRequest(){
        return CourseCreateRequest.builder().courseName("science").build();
    }
}
