package com.example.demo;

import com.example.demo.dao.alpha.UserMapper;
import com.example.demo.domain.alpha.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired(required = false)
    private UserMapper userMapper;


    @Test
    public void contextLoads() {
        log.info("test");
        List<User> users = userMapper.selectAll();
        log.info("数据：{}",users);
    }

}
