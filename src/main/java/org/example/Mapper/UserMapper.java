package org.example.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.entity.User;

@Mapper
public interface UserMapper{
    User getUserByUserName(String userName);

    int insertUser(User user);
}