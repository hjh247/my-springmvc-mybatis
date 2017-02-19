package com.hjh247.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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


}
