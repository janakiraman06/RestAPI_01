package com.example.school.controller;

/**
 * Created by Janak on 09-05-2020.
 */

import com.example.school.entity.Student;
import com.example.school.manager.StudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/student")
public class StudentController {

    @Autowired
    StudentManager studentManager;

    @RequestMapping(path ="/", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.TEXT_PLAIN_VALUE)
    public String addStudent (@RequestBody Student student){
        return studentManager.addStudent(student);
    }

    @RequestMapping(path = "/", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Iterable<Student> displayAllStudents(){
        return studentManager.displayAllStudents();
    }

    @RequestMapping(path ="/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Student displayStudent(@PathVariable(name = "id") int sId){
        System.out.println("Searching by ID  : " + sId);
        return studentManager.displayStudent(sId);
    }

    //check if two parameter is okay??  -- just object is enough
    @RequestMapping(path ="/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateStudent(@PathVariable(name = "id") int sId, @RequestBody Student student){
        return studentManager.updateStudent(sId, student);
    }

    @RequestMapping(path ="/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteStudent(@PathVariable(name = "id") int sId){
        return  studentManager.deleteStudent(sId);
    }

}
