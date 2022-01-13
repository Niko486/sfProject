package com.sf.controller;

import com.sf.pojo.Page;
import com.sf.pojo.User;
import com.sf.service.UserService;
import com.sf.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/select")
    public SysResult selectAll(Page page) {
        System.out.println(page);
        List<User> user = userService.selectAll(page);
        return SysResult.success(user);
    }

    public SysResult selectAll(User user) {
        userService.insert(user);
        return SysResult.success();
    }

    @PostMapping("/login")
    public SysResult userLogin(@RequestBody User user) {
        if (user.getUsername() == null)
            return SysResult.fail("登录失败，请检查用户名");
        String msg = userService.login(user);
        if ("用户名不存在".equals(msg))
            return SysResult.fail(msg);
        else if ("密码错误".equals(msg))
            return SysResult.fail(msg);
        return SysResult.success();
    }

    @PutMapping("/register")
    public SysResult userRegister(@RequestBody User user) {
        boolean insert = userService.insert(user);
        if (insert)
            return SysResult.success();
        return SysResult.fail();
    }
}
