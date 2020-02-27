package com.example.spring.repositories;

import com.example.spring.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CourseRepository extends JpaRepository<Course ,Long> {
}
