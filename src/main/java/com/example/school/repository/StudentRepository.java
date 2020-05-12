package com.example.school.repository;

import com.example.school.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Janak on 09-05-2020.
 */

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
}
