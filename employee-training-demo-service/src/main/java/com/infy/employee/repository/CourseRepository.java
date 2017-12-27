package com.infy.employee.repository;

import com.infy.employee.common.Constants;
import com.infy.employee.entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "courses",path = Constants.COURSE_RESOURCE)
public interface CourseRepository extends JpaRepository<Course,UUID>{

    Course findOne(UUID courseId);

    @RestResource (path = Constants.FIND_BY_FIRST_NAME)
    Page<Course> findByCourseName(@Param("courseName")String courseName, Pageable pageable);

}
