package com.infy.employee.repository;

import com.infy.employee.common.Constants;
import com.infy.employee.entity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "employees",path = Constants.EMPLOYEE_RESOURCE)
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,UUID> {

    List<Employee> findByEmpFirstName(String firstName);

    Employee save(Employee employeeCreateRequest);

}


