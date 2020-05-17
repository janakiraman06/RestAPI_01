package com.example.school.manager;

import com.example.school.entity.Student;
import com.example.school.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import javax.persistence.Id;
import java.util.List;

/**
 * Created by Janak on 09-05-2020.
 */

@Service
public class StudentManager {

    private final Logger LOGGER = LoggerFactory.getLogger(StudentManager.class);

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    RestTemplateClient restTemplateClient;
    public String addStudent (Student student){
        studentRepository.save(student);
        return "Student added";
    }

    public Iterable<Student> displayAllStudents(){
        return studentRepository.findAll();
    }

    @Cacheable(value ="student", keyGenerator = "studentKeyGenerator" /*key = "#sId", condition = "#sId <2", unless = "#sId > 5"*/)
    public Student displayStudent(int sId){
            LOGGER.info("Entering displayStudent in StudentManager");
            //System.out.println("Sleep 5s");
            //Thread.sleep(5000);
        return studentRepository.findById(sId).get();
    }

    public String updateStudent(int sId, Student student){
        if(studentRepository.findById(sId).isPresent()) {
            studentRepository.save(student);
            return "Student updated";
        }
        else
            return "Sorry, no such student exists";
    }

    public String deleteStudent(int sId){
        String uri;
        if(studentRepository.findById(sId).isPresent()) {
            uri="http://localhost:8080/marks/"+sId;
            studentRepository.deleteById(sId);
            restTemplateClient.delete(uri);
            return  "Student deleted";
        }

        else
            return "Sorry, no such student exists";
    }
}
