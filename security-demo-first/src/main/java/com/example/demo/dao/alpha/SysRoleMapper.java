package com.example.demo.dao.alpha;

import com.example.demo.domain.alpha.SysPermission;
import com.example.demo.domain.alpha.SysRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysRoleMapper extends Mapper<SysRole> {

  List<SysPermission>  findAll();

  List<SysPermission> findByAdminUserId(int userId);
}