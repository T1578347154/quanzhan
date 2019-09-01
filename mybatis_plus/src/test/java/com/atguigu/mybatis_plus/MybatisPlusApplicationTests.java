package com.atguigu.mybatis_plus;

import com.atguigu.mybatis_plus.base.User;
import com.atguigu.mybatis_plus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatisPlusApplicationTests {
   @Autowired
   UserMapper userMapper;
    @Test
    public void contextLoads() {

        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }
   @Test
    public void testDelecte(){
       QueryWrapper<User> queryWrapper = new QueryWrapper<>();
       queryWrapper.isNull("name").ge("age",12).isNotNull("email");
       int delete = userMapper.delete(queryWrapper);
       System.out.println(delete);
   }
}
