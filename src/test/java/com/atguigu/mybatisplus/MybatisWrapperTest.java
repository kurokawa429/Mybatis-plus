package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisWrapperTest {

    @Autowired
    UserMapper userMapper;

    @Test
    public void selectTest(){
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.like("name","a");
        qw.between("age",21,30);
        qw.isNotNull("email");
        List<User> userList = userMapper.selectList(qw);
        System.out.println(userList);
    }

    @Test
    public void deleteTest(){

    }
}
