package com.mpitheima.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mpitheima.mapper.UserMapper;
import com.mpitheima.pojo.User;
import com.mpitheima.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
}
