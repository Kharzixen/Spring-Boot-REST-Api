package com.kharzixen.schooladministrationrestapi.repository;

import com.kharzixen.schooladministrationrestapi.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
