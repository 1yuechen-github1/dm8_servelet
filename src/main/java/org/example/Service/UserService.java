package org.example.Service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    User getUserByUserName(String userName);

    int insertUser(User user);
}
