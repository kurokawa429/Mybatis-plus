package com.atguigu.mybatisplus;

import com.atguigu.mybatisplus.mapper.UserMapper;
import com.atguigu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert(){
        List<User> userList = Stream.of(new User(55L, "张三", 15, "123"), (new User(56L, "李四", 23, "123")),
                (new User(57L, "王五", 55, "123"))).collect(Collectors.toList());
        userList.stream().forEach(s -> userMapper.insert(s));
        List<User> userData = userMapper.selectList(null);
        userData.forEach(System.out::println);
    }

    @Test
    public void testDelete(){
        int row = userMapper.deleteById(55L);

        List<Long> idList = Arrays.asList(55l, 56l, 57l);
        int rows = userMapper.deleteBatchIds(idList);

        HashMap<String,Object> map = new HashMap<>();
        map.put("name" , "张三");
        map.put("age" , "15");
        int rows1 = userMapper.deleteByMap(map);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(55L);
        user.setAge(18);

        userMapper.updateById(user);
        List<User> userData = userMapper.selectList(null);
        userData.forEach(System.out::println);
    }

    @Test
    public void testSelect(){
        Map<String, Object> map =
                userMapper.selectMapById(55L);
        System.out.println(map);
    }
}
