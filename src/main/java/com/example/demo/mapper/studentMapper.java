package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface studentMapper extends BaseMapper<student> {
}
