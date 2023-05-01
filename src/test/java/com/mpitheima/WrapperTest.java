package com.mpitheima;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mpitheima.mapper.UserMapper;
import com.mpitheima.pojo.User;
import com.mpitheima.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
public class WrapperTest {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;
    @Test
    public void test1() {
        //方式一 按条件查询
//        QueryWrapper qw=new QueryWrapper();
//        qw.gt("age",18);
//        List<User> list = userMapper.selectList(qw);
//        list.forEach(user -> System.out.println(user));

        //方式二:Lambda格式按条件查询
//        QueryWrapper<User> qw=new QueryWrapper<>();
//        qw.lambda().gt(User::getAge,18);
//        List<User> list = userMapper.selectList(qw);
//        list.forEach(user -> System.out.println(user));

        //方式三:LambdaQueryWrapper
//        LambdaQueryWrapper<User> qw=new LambdaQueryWrapper<User>();
//        qw.gt(User::getAge,18).eq(User::getTel,159834059);
//        List<User> list = userMapper.selectList(qw);
//        list.forEach(user -> System.out.println(user));

//        LambdaQueryWrapper<User> qw=new LambdaQueryWrapper<>();
//        qw.lt(User::getAge,65).ge(User::getAge,18);
//        List<User> list = userMapper.selectList(qw);
//        list.forEach(user -> System.out.println(user));


//        LambdaQueryWrapper<User> qw=new LambdaQueryWrapper<>();
//        qw.ge(User::getAge,18).or().lt(User::getAge,65);
//        List<User> list = userMapper.selectList(qw);
//        list.forEach(user -> System.out.println(user));

        //查询投影LambdaQueryWrapper格式
//        LambdaQueryWrapper<User> lqw=new LambdaQueryWrapper<>();
//        lqw.select(User::getId,User::getTel);
//        List<User> list = userMapper.selectList(lqw);
//        System.out.println(list);

        //查询投影QueryWrapper格式
//        QueryWrapper<User> qw=new QueryWrapper<>();
//        qw.select("id", "name","tel");
//        qw.groupBy("tel");
//        List<Map<String, Object>> maps = userMapper.selectMaps(qw);
//        System.out.println(maps);

        //登录操作
//        LambdaQueryWrapper<User> qw=new LambdaQueryWrapper<>();
//        qw.between(User::getAge,15,21);
//        qw.select(User::getName,User::getPassword);
//        //qw.eq(User::getName,"Jerry").eq(User::getPassword,"jerry");
//        System.out.println(userMapper.selectList(qw));

        //模糊匹配
        LambdaQueryWrapper<User> qw=new LambdaQueryWrapper<>();
     //   qw.select(User::getName,User::getTel);
        qw.likeRight(User::getName, "J");
        List<User> list = userMapper.selectList(qw);
        System.out.println(list);
    }

    @Test
    public void test2() {
        User user=new User();
        user.setTel("159");
        user.setName("xiezhonghui");
        user.setAge(21);
        userMapper.insert(user);
    }

    @Test
    public void test3() {
        List list=new ArrayList();
        list.add(1647460794319130625l);
        list.add(1647462433314713602l);
        userMapper.deleteBatchIds(list);
    }

    @Test
    public void test4() {
        int i = userMapper.deleteById(3);
        System.out.println(i);
//        List<User> list = userMapper.selectList(null);
//        System.out.println(list);
    }

    @Test
    public void test5() {
//        User user=new User();
//        user.setName("北京大学");
//        user.setVersion(1);
//        user.setId(1646832465404674049l);
        User user = userMapper.selectById(1646832465404674049l);
        user.setName("清华大学");
        userMapper.updateById(user);
    }
}