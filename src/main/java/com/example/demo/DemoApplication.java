package com.example.demo;

import com.example.demo.mapper.studentMapper;
import com.example.demo.pojo.student;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
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
    public String findAll()   {
        List<student> students = studentMapper.selectList(null);
        return  students.toString();
    }
    
    @RequestMapping("/getById")
    public String getById(Integer id){
        student stu = studentMapper.selectById(id);
        return stu.toString();
    }
    
    @RequestMapping("/save")
    public int save(){
        student stu = new student();
        Random rd = new Random(10);
        stu.setId((int)((Math.random()*9+1)*10000));
        stu.setName("zhang"+rd.nextInt());
        stu.setSex("y");
        return studentMapper.insert(stu);
    }
    @RequestMapping("/deleteById")
    public int delete(Integer id){
        return studentMapper.deleteById(id);
    }

    @RequestMapping("/updateById")
    public int  update(){
        student stu = new student();
        Random rd = new Random(10);
        stu.setId(1);
        stu.setName("zhang"+(int)((Math.random()*9+1)));
        stu.setSex("y");
        return studentMapper.updateById(stu);
    }
    @RequestMapping("/getCount")
    public Long getCount(){
        return studentMapper.selectCount(null);
    }

    @RequestMapping("/task1")
    public String task1(){
        Runnable runnable = new Runnable() {
            //创建 run 方法
            public void run() {
//                 studentMapper.selectList(null);
//                 System.out.println("Hello, stranger");
                student stu = new student();
                stu.setId((int)((Math.random()*9+1)*10000));
                stu.setName("llll"+(int)((Math.random()*9+1)));
                stu.setSex("y");
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        // 10：秒   5：秒
        // 第一次执行的时间为10秒，然后每隔五秒执行一次
        service.scheduleAtFixedRate(runnable, 3, 2, TimeUnit.SECONDS);
        
        return "Success!";
    }
}

