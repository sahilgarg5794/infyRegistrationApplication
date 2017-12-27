package com.infy.employee.configuration;

import com.infy.employee.entity.Course;
import com.infy.employee.entity.Employee;
import com.infy.employee.entity.Registration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class RepositoryConfiguration extends RepositoryRestConfigurerAdapter {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Employee.class,
                            Course.class,
                            Registration.class);
    }
}
