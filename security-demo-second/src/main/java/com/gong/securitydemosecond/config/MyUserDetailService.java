package com.gong.securitydemosecond.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author GEEX616
 * @create 2019-09-09 15:20
 * @desc
 **/
@Component
public class MyUserDetailService implements UserDetailsService {

    private static Logger logger= LoggerFactory.getLogger(MyUserDetailService.class);


    @Autowired(required = false)
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("当前用户名为：{}",username);
        String password = passwordEncoder.encode("123456");
        logger.info("当前密码为：{} ",password);
        //当前的user是UserDetail实现类，但是正常开发中，需要用系统的用户集成此类，实现相关方法
        return new User(username, password, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }
}
