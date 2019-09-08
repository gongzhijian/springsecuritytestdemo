package com.example.demo.dao.alpha;

import com.example.demo.domain.alpha.SysUser;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

public interface SysUserMapper extends Mapper<SysUser> {
    SysUser findByUserName(@Param("userName") String userName);

}