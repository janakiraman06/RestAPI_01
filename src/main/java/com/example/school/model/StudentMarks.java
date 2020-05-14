package com.example.school.model;

import com.example.school.entity.Marks;
import com.example.school.entity.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Janak on 11-05-2020.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Component
/*@XmlRootElement*/
public class StudentMarks{
    private Student sStudent;
    private Marks sMarks;

    public Student getsStudent() {
        return sStudent;
    }

    public void setsStudent(Student sStudent) {
        this.sStudent = sStudent;
    }

    public Marks getsMarks() {
        return sMarks;
    }

    public void setsMarks(Marks sMarks) {
        this.sMarks = sMarks;
    }
}
