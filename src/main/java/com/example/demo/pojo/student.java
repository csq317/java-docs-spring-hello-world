package com.example.demo.pojo;


import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("student")
public class    student {
    @TableId(value="id" , type =IdType.AUTO)
    private Integer id;
    private String name;
    private String sex;
}
