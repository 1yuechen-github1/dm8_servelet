package org.example.Service.Impl;

//import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.Mapper.UserMapper;
import org.example.Service.UserService;
import org.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String userName) {
      return userMapper.getUserByUserName(userName);
    }

    @Override
    public int insertUser(User user) {
        return userMapper.insertUser(user);
    }

    @Override
    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public boolean updateUserByUserId(User user) {
        return userMapper.updateUserByUserId(user);
    }
}
