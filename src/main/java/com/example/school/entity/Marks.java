package com.example.school.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Janak on 10-05-2020.
 */

@Entity
/*@XmlRootElement*/
public class Marks implements Serializable {

    @Id
    @Column(name = "student_id")
    int studentId;

    @Column(name = "tamil")
    short tamil;

    @Column(name = "english")
    short english;

    @Column(name = "maths")
    short maths;

    @Column(name = "science")
    short science;

    @Column(name = "social_science")
    short socialScience;

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public short getTamil() {
        return tamil;
    }

    public void setTamil(short tamil) {
        this.tamil = tamil;
    }

    public short getEnglish() {
        return english;
    }

    public void setEnglish(short english) {
        this.english = english;
    }

    public short getMaths() {
        return maths;
    }

    public void setMaths(short maths) {
        this.maths = maths;
    }

    public short getScience() {
        return science;
    }

    public void setScience(short science) {
        this.science = science;
    }

    public short getSocialScience() {
        return socialScience;
    }

    public void setSocialScience(short socialScience) {
        this.socialScience = socialScience;
    }
}
