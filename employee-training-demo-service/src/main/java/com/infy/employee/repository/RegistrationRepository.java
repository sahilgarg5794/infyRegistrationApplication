package com.infy.employee.repository;

import com.infy.employee.common.Constants;
import com.infy.employee.entity.Course;
import com.infy.employee.entity.Registration;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = Constants.REGISTRATION_RESOURCE,path = Constants.REGISTRATION_RESOURCE)
public interface RegistrationRepository extends PagingAndSortingRepository<Registration,UUID>{

    Registration findByCourse(Course course);


}
