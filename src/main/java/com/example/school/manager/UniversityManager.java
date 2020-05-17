package com.example.school.manager;

import com.example.school.entity.Marks;
import com.example.school.entity.Student;
import com.example.school.model.StudentMarks;
import com.example.school.repository.UniversityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Janak on 10-05-2020.
 */
@Service
public class UniversityManager {

    @Autowired
    UniversityRepository universityRepository;
    @Autowired
    RestTemplateClient restTemplateClient;
    @Autowired
    StudentMarks studentMarks;
    public String addMarks (@RequestBody Marks marks) {
         universityRepository.save(marks);
         return "Marks added";
    }

    @Cacheable(value = "studentMarks", key = "#studentId", condition = "#studentId>1")
    public StudentMarks getMarksWithSudents(int studentId){
        final String uri = "http://localhost:8080/student/" + studentId;
        ResponseEntity<Student> studentResponseEntity =  restTemplateClient.getForEntity(uri, Student.class);
        Student student = studentResponseEntity.getBody();
        Marks marks = universityRepository.findById(studentId).get();
        studentMarks.setsStudent(student);
        studentMarks.setsMarks(marks);
        return studentMarks;
    }
    public String deleteMarks(int studentId){
        universityRepository.deleteById(studentId);
        return "Marks deleted";
    }
}
