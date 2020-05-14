package com.example.school.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Janak on 09-05-2020.
 */
@Entity
/*@XmlRootElement*/
@Table(name="students")
public class Student {

    @Id
    @Column(name="s_id")
    @GeneratedValue
    private int sId;

    @Column(name="first_name")
    private  String sFirstName;

    @Column(name="last_name")
    private String sLastName;

    @Column(name="email", nullable = false, length = 50)
    private String sEmail;


    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsFirstName() {
        return sFirstName;
    }

    public void setsFirstName(String sFirstName) {
        this.sFirstName = sFirstName;
    }

    public String getsLastName() {
        return sLastName;
    }

    public void setsLastName(String sLastName) {
        this.sLastName = sLastName;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    @Override
    public String toString(){
        return "EmployeeEntity [id=" + sId + ", firstName=" + sFirstName + ", lastName=" + sLastName + ", email=" + sEmail + "]";
    }
}
