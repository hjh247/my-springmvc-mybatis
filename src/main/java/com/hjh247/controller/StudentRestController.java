package com.hjh247.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hjh247.mybatis.model.Student;
import com.hjh247.service.StudentService;

@Controller
@RequestMapping("/rest")
public class StudentRestController {

    private Logger logger = Logger.getLogger(StudentRestController.class);

    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping(value="/student/{id}",method=RequestMethod.GET)
    public Student getStudent(@PathVariable("id") Integer id){
        logger.info("rest api: start getting");
        Student student = studentService.selectByPrimaryKey(id);
        return student;
    }

    @RequestMapping(value="/students",method=RequestMethod.GET)
    public @ResponseBody List<Student> listStudent(){
        logger.info("rest api: start listing");
        List<Student> students = studentService.getAll();
        return students;
    }

    @RequestMapping(value="/update",method=RequestMethod.POST)
    public @ResponseBody List<Student> updateStudent(@RequestBody Student student){
        logger.info("rest api: start update");
        studentService.update(student);
        List<Student> students = studentService.getAll();
        return students;
    }
}
