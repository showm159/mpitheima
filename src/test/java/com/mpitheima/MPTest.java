package com.mpitheima;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mpitheima.mapper.UserMapper;
import com.mpitheima.pojo.User;
import com.mpitheima.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MPTest {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserService userService;

    @Test
    public void test(){
        List<User> users = userMapper.selectList(null);
       // users.forEach(user -> System.out.println(user));
        for (User user : users){
            System.out.println(user);
        }
    }

    @Test
    public void test2(){
        Object o = userMapper.selectById(1);
        System.out.println(o);
    }


    @Test
    public void test4(){
        ArrayList arrayList=new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        List<User> list = userService.listByIds(arrayList);
        System.out.println(list);
    }

    @Test
    public void test5(){
        User user = new User();
        user.setName("北大");
        user.setAge(21);
        userMapper.insert(user);
    }

    @Test
    public void test6(){
        User user = new User();
        user.setName("北大");
        user.setAge(21);
        userMapper.insert(user);
    }

    @Test
    public void test7(){
        int i = userMapper.deleteById(1646832802156994561l);
        System.out.println(i);
    }

    @Test
    public void test8(){
        User user=new User();
      //  User user1=new User(1l,"xoe","xie",1,"1");
        user.setId(1646832465404674049L);
        user.setTel("159834059");
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    @Test
    public void test9(){
        IPage page=new Page(2,2);
        userMapper.selectPage(page,null);
        System.out.println(page.getRecords());
        System.out.println("一共多少页数据:"+page.getPages());
    //    System.out.println("一共多少条数据:"+page.getTotal());
    }

    @Test
    public void test10(){
        Page<User> page=new Page<>(2,2);
        page = userService.page(page, null);
        System.out.println(page.getRecords());
    }
}