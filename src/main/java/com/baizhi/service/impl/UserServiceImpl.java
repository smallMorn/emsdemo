package com.baizhi.service.impl;

import com.baizhi.dao.UserMapper;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;
    @Override
    public User selectOne(User user) {
        return userMapper.selectOne(user);
    }
    //分页查询
    @Override
    public Map selectByPage(int page,int rows){
        Map map = new HashMap();
        int start = (page-1)*rows;
        List<User> list = userMapper.selectByPage(start, rows);
        logger.info("++++++++"+list);
        map.put("rows",list);
        int number = userMapper.selectAccount();
        map.put("total",number);
        return map;
    }
    //注册
    @Override
    public void register(User user) {
       userMapper.insertSelective(user);
    }
    //批量删除
    @Override
    public void multiDelete(int[] ids) {
        userMapper.multiDelete(ids);
    }
    //根据id查询
    @Override
    public User selectById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
    //修改
    @Override
    public void update(User user) {
        int i = userMapper.updateByPrimaryKeySelective(user);
    }
}
