package com.infy.employee.controller;

import com.infy.employee.domain.request.EmployeeCreateRequest;
import com.infy.employee.domain.response.EmployeeCreateResponse;
import com.infy.employee.entity.Employee;
import com.infy.employee.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestController
@RequestMapping(value = "/employees")
@Api(value = "Employee Controller")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value="get Employees by First Name")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "Success")})
    @RequestMapping(value = "findByEmpFirstName",produces = {MediaType.APPLICATION_JSON_VALUE},method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> getEmployeesByFirstName(@RequestParam(name="firstName") String firstName){
        System.out.println("inside controller of find by first name"+firstName);
        List<Employee> employees=employeeService.getEmployeesByFirstName(firstName);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @ApiOperation(value="Create Employee")
    @ApiResponses(value = {@ApiResponse(code = 200,message = "Success")})
    @RequestMapping(value="createEmployee",method = RequestMethod.POST)
    public ResponseEntity<EmployeeCreateResponse> createEmployee(@RequestBody EmployeeCreateRequest employeeCreateRequest){
        EmployeeCreateResponse employee = employeeService.saveEmployeeToDB(employeeCreateRequest);
        return new ResponseEntity<>(employee,HttpStatus.CREATED);
    }

}
