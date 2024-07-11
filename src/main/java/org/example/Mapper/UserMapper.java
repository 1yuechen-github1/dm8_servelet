package org.example.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.UpdateProvider;
import org.example.SqlBuilder.StudentSqlBuilder;
import org.example.entity.User;

@Mapper
public interface UserMapper{
    User getUserByUserName(String userName);

    int insertUser(User user);

    User getUserById(int id);

//    @UpdateProvider(type = StudentSqlBuilder.class, method = "buildUpdateUserByUserId")
    boolean updateUserByUserId(User user);


}