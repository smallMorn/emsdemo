package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.Map;

public interface UserService {
    User selectOne(User user);
    Map selectByPage(int page,int rows);
    void register(User user);
    void multiDelete(int[] ids);
    //根据id查询
    User selectById(int id);
    //修改
    void update(User user);
}
