package com.sf.service;

import com.sf.pojo.Page;
import com.sf.pojo.User;

import java.util.List;

public interface UserService {
    List<User> selectAll(Page page);
    boolean insert(User user);
    String login(User user);
}
