package com.example.school.controller;

import com.example.school.entity.Marks;
import com.example.school.entity.Student;
import com.example.school.manager.UniversityManager;
import com.example.school.model.StudentMarks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Janak on 10-05-2020.
 */

@RestController
@RequestMapping(path = "/marks")
public class UniversityController {

    @Autowired
    UniversityManager universityManager;

    @RequestMapping(path ="/", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String addMarks (@RequestBody Marks marks) {
        return universityManager.addMarks(marks);
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public StudentMarks getMarksWithSudents(@PathVariable(name = "id") int studentId){
        return universityManager.getMarksWithSudents(studentId);
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String deleteMarks(@PathVariable(name = "id") int studentId){
        return universityManager.deleteMarks(studentId);
    }

}
