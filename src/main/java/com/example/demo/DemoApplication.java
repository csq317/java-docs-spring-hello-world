package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
   @RequestMapping("/byc")
  public  String sayHello() throws ClassNotFoundException, SQLException {
        String driverName = "com.mysql.cj.jdbc.Driver";
        String DB_URL = "jdbc:mysql://47.98.237.169:3306";
        String USER = "root";
	Class.forName(driverName);
	Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	return conn.toString()+"byc";
    }
}
