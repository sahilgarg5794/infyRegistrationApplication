package com.infy.employee.domain;

import com.infy.employee.entity.Employee;
import com.infy.employee.entity.Course;
import org.springframework.data.rest.core.config.Projection;
import java.util.List;
import java.util.UUID;

@Projection(name="employeeProjection",types = {Employee.class})
public interface EmployeeProjection {

    UUID getId();

    String getEmpFirstName();

    String getEmpLastName();

    List<Course> getCourses();

}
