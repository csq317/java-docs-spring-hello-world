package com.example.demo;

import com.example.demo.mapper.studentMapper;
import com.example.demo.pojo.student;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import javax.annotation.Resource;
import java.util.List;

@SpringBootApplication
@RestController
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

    @Resource   
    private  studentMapper studentMapper;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

   @RequestMapping("/findAll")
    public String sayHello()   {
        List<student> students = studentMapper.selectList(null);
        return  students.toString();
    }
    
    @RequestMapping("/getById")
    public String getById(Integer id){
        student stu = studentMapper.selectById(id);
        return stu.toString();
    }
    
    @RequestMapping("/save")
    public boolean save(){
        student stu = new student();
        Random rd = new Random(10);
        stu.setId((int)((Math.random()*9+1)*10000));
        stu.setName("zhang"+rd.nextInt());
        stu.setSex("y");
        return studentMapper.insert(stu);
    }
    @RequestMapping("/deleteById")
    public boolean delete(Integer id){
        return studentMapper.deleteById(id);
    }

    @RequestMapping("/updateById")
    public boolean update(){
        student stu = new student();
        Random rd = new Random(10);
        stu.setId(1);
        stu.setName("zhang"+rd.nextInt());
        stu.setSex("y");
        return studentMapper.updateById(stu);
    }
}

