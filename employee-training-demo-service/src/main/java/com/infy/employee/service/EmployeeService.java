package com.infy.employee.service;

import com.infy.employee.entity.Employee;
import com.infy.employee.domain.request.EmployeeCreateRequest;
import com.infy.employee.domain.response.EmployeeCreateResponse;
import com.infy.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployeesByFirstName(String employeeFirstName){
        System.out.println(employeeRepository.findByEmpFirstName(employeeFirstName)+"------------------------------->inside repository call");
        return employeeRepository.findByEmpFirstName(employeeFirstName);
    }

    public EmployeeCreateResponse saveEmployeeToDB(EmployeeCreateRequest employeeCreateRequest){
        Employee employee=Employee.builder().empFirstName(employeeCreateRequest.getFirstName())
                .empLastName(employeeCreateRequest.getLastName()).build();
       employeeRepository.save(employee);
       return new EmployeeCreateResponse(HttpStatus.CREATED.value(),"Employee Entity Got Created");
    }
}
