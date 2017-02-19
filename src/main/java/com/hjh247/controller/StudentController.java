package com.hjh247.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hjh247.mybatis.model.Student;
import com.hjh247.service.StudentService;

@Controller
@RequestMapping("/studentController")
public class StudentController {

    private Logger logger = Logger.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @RequestMapping(value="/listStudent")
    public String listStudent(HttpServletRequest request) {
        List<Student> list = studentService.getAll();
        request.setAttribute("studentlist", list);
        return "listStudent";
    }

    @RequestMapping(value="/addStudent")
    public String addStudent(Student student) {
        studentService.insert(student);
        return "redirect:/studentController/listStudent.do";
    }

    @RequestMapping(value="/deleteStudent")
    public String deleteUser(Integer id) {
        studentService.delete(id);
        return "redirect:/studentController/listStudent.do";
    }

    @RequestMapping(value="/updateStudentUI")
    public String updateStudentUI(Integer id, HttpServletRequest request) {
        Student student = studentService.selectByPrimaryKey(id);
        request.setAttribute("student", student);
        return "updateStudent";
    }

    @RequestMapping(value="/updateStudent")
    public String updateStudent(Student student) {
        System.out.println("ccc:"+ student.getName());
        studentService.update(student);
        return "redirect:/studentController/listStudent.do";
    }
}

