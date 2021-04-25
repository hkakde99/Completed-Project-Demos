package com.spring.boot.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.spring.boot.entities.Student;

@Service
public interface StudentService extends CrudRepository<Student, Integer> {

}
