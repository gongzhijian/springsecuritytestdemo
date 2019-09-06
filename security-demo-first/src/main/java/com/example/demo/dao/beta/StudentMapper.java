package com.example.demo.dao.beta;

import com.example.demo.domain.beta.Student;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}