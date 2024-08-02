package com.demo.crud.dao;

import com.demo.crud.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student readStudent(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String name);
}
