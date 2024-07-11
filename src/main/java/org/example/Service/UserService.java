package org.example.Service;

//import com.baomidou.mybatisplus.extension.service.IService;
import org.example.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User getUserByUserName(String userName);

    int insertUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    boolean updateUserByUserId(User user);
}
