package com.sf.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sf.mapper.UserMapper;
import com.sf.pojo.Page;
import com.sf.pojo.User;
import javafx.scene.image.PixelFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectAll(Page page) {
       User user = userMapper.selectById(1);
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.like("username", "%"+page.getQuery()+"%");
        List<User> users = userMapper.selectList(qw);
        return users ;
    }

    @Override
    public boolean insert(User user) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("username", user.getUsername());
        User user1 = userMapper.selectOne(userQueryWrapper);
        if (user1 != null)
            return false;
        user.setCreated(new Date()).setUpdated(new Date()).setMember(false).setWriter(false);
        int insert = userMapper.insert(user);
        if (insert == 0)
            return false;
        return true;
    }

    @Override
    public String login(User user) {
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.eq("username", user.getUsername());
        User users = userMapper.selectOne(qw);
        if (users == null){
            return "用户名不存在";
        }else if (!users.getPassword().equals(user.getPassword())){
            return "密码错误";
        }
        return "登录成功";
    }
}
