package com.example.demo.dao.alpha;

import com.example.demo.domain.alpha.SysUser;
import com.example.demo.domain.alpha.User;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface UserMapper extends Mapper<User> {
}