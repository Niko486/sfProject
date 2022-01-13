package com.sf.test;

import com.sf.mapper.UserMapper;
import com.sf.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class Demo {
    @Autowired
    private UserMapper userMapper;

    @Test
    void insert01(){
        User user = new User();
        user.setUsername("niko");
        userMapper.insert(user);
    }
}
