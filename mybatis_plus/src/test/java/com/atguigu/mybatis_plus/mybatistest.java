package com.atguigu.mybatis_plus;

import com.atguigu.mybatis_plus.base.User;
import com.atguigu.mybatis_plus.mapper.UserMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class mybatistest {
    @Autowired
    UserMapper userMapper;
    @Test
    public void test(){

        User user=new User();
        user.setName("杨幂");
        user.setAge(28);
        user.setEmail("15248@qq.com");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user);
    }
    @Test
    public void tests(){
        User user=new User();
        user.setId(1l);
        user.setName("刘亦菲");
        int insert = userMapper.updateById(user);
        System.out.println(insert);
        System.out.println(user);
    }
 @Test
    public void testSelectById(){
     User user = userMapper.selectById(1156910233713504257l);
     System.out.println(user);
 }
 @Test
    public void  tsetSelectbyMap(){
     Map<String,Object>map=new HashMap<>();
      map.put("name","Jone");
      map.put("age",18);
     List<User> users = userMapper.selectByMap(map);
     users.forEach(System.out::println);
 }
 @Test
    public  void  testSelctPage(){
     Page<User> page = new Page<>(2, 5);//每页 5条数据
      //     userMapper.selectPage(page,null);
       //page.getRecords().forEach(System.out::println);

     IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(page, null);
     //注意：此行必须使用 mapIPage 获取记录列表，否则会有数据类型转换错误
     mapIPage.getRecords().forEach(System.out::println);
     System.out.println(page.getCurrent());//第几页
     System.out.println(page.getPages());// 一共几页
     System.out.println(page.getSize());// 每页 5条数据
     System.out.println(page.getTotal());// 一共 八条 数据
     System.out.println(page.hasNext());//下一页
     System.out.println(page.hasPrevious());//上一页

 }

 @Test
    public void testDelect(){
     int i = userMapper.deleteById(1l);
     System.out.println(i);

 }
    @Test
    public void testDelects(){
        int i = userMapper.deleteBatchIds(Arrays.asList(2, 3, 4));
        System.out.println(i);

    }
    @Test
    public void testLogicDelete() {
        int result = userMapper.deleteById(1156908401142362113l);

        System.out.println(result);

    }

    @Test
    public void testLogicDeleteSelect() {

        User user = new User();
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);

    }


}
