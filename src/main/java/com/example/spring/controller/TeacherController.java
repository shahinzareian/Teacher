package com.example.spring.controller;

import com.example.spring.models.Course;
import com.example.spring.models.Teacher;
import com.example.spring.repositories.TeacherRepository;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/teachers")

public class TeacherController {
    @Autowired
   private TeacherRepository teacherRepository;
    

    @GetMapping
    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();

    }
    @PostMapping
    public void addTeacher(@RequestBody Teacher teacher){
        teacherRepository.save(teacher);

    }
    @DeleteMapping("{id}")
    public void deleteTeacher(@PathVariable Long id) {
        teacherRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody Teacher teacher) throws NotFoundException {
        Optional<Teacher> originalTeacher = teacherRepository.findById(id);
        if(!originalTeacher.isPresent()) {
            throw new NotFoundException("Teacher not found");
        }
        teacher.setId(id);
        teacherRepository.save(teacher);
    }

}
