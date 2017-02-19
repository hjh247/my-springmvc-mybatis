package com.hjh247.service;

import java.util.List;

import com.hjh247.mybatis.model.Student;

public interface StudentService {

    List<Student> getAll();

    Student selectByPrimaryKey(Integer id);

    int insert(Student student);

    int update(Student student);

    int delete(Integer id);
}
