package com.example.spring.controller;

import com.example.spring.models.Course;
import com.example.spring.models.Teacher;
import com.example.spring.repositories.CourseRepository;
import com.example.spring.repositories.TeacherRepository;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")

public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> getCourse() {
        return courseRepository.findAll();

    }

    @PostMapping
    public void addCourse(@RequestBody Course course) {
        courseRepository.save(course);

    }

    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Course course) throws NotFoundException {
        Optional<Course> originalCourse = courseRepository.findById(id);
        if(!originalCourse.isPresent()) {
            throw new NotFoundException("Course not found");
        }
        course.setId(id);
        courseRepository.save(course);
    }

}