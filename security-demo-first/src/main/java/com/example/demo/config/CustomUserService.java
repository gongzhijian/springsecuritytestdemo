package com.example.demo.config;

import com.example.demo.dao.alpha.SysRoleMapper;
import com.example.demo.dao.alpha.SysUserMapper;
import com.example.demo.dao.alpha.UserMapper;
import com.example.demo.domain.alpha.SysPermission;
import com.example.demo.domain.alpha.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {

    private static Logger logger=LoggerFactory.getLogger(CustomUserService.class);

    @Autowired(required = false)
    private SysUserMapper sysUserMapper;

    @Autowired(required = false)
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private MyPasswordEncorder myPasswordEncorder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //查询数据的用户对象
        logger.info("当前用户为：{}",username );
        SysUser user = sysUserMapper.findByUserName(username);
        if(user != null) {
            List<SysPermission> permissions = sysRoleMapper.findByAdminUserId(user.getId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (SysPermission permission : permissions) {
                if (permission != null && permission.getName()!=null) {

                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new User(user.getUsername(), myPasswordEncorder.encode(user.getPassword()), grantedAuthorities);

        }else {
            throw new  UsernameNotFoundException("not find this user,please check!");
        }

    }
}
