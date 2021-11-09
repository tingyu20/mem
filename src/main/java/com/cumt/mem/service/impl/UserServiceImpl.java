package com.cumt.mem.service.impl;

import com.cumt.mem.bean.User;
import com.cumt.mem.service.UserService;

import com.cumt.mem.dao.UserDao;
import com.cumt.mem.dao.impl.UserDaoImpl;
import org.springframework.stereotype.Service;


@Service(value = "userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        /**
         * 咱们的登录，需要查询数据库
         *
         */
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {

        if (userDao.queryUserByUsername(username) == null) {
            // 等于null,说明没查到，没查到表示可用
            return false;
        }

        return true;

    }
}
