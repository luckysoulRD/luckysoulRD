package com.vitthal.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.vitthal.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
