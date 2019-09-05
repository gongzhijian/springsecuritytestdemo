package com.example.demo;

import com.example.demo.dao.alpha.UserMapper;
import com.example.demo.domain.alpha.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

      Logger logger= LoggerFactory.getLogger(DemoApplicationTests.class);

    @Autowired(required = false)
    private UserMapper userMapper;


    @Test
    public void contextLoads() {
        List<User> users = userMapper.selectAll();
        logger.info("用户的量为：{}",users.size());
        User user = new User();
        user.setId(1);
        User selectOne = userMapper.selectOne(user);
        logger.info("用户id为1的人是：{}", selectOne);
    }

    @Test
    @Transactional
    public void testTransactional() {
        User user = new User();
        user.setName("唐慧是个猫");
        logger.info("操作前人员{}", "未执行");
        userMapper.insert(user);
        logger.info("操作后人员{}","已执行");
        if (user.getId()==1){
            throw  new RuntimeException("操作失败，重试中");
        }
        User user2 = new User();
        user2.setName("boook");
        userMapper.insert(user2);
        logger.info("嘻嘻");
    }



}
