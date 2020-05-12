package com.example.school.repository;

import com.example.school.entity.Marks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Janak on 10-05-2020.
 */

@Repository
public interface UniversityRepository extends CrudRepository <Marks , Integer> {

}
