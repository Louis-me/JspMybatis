package xyz.shi.service.impl;

import xyz.shi.dao.UserDao;
import xyz.shi.dao.impl.UserDaoImpl;
import xyz.shi.entity.User;
import xyz.shi.service.UserService;
import java.util.List;

public class UserServiceImpl implements UserService {
    //创建UserDaoImpl对象
    private UserDao userDao = new UserDaoImpl();

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public User queryOne(User user) {
        return userDao.queryOne(user);
    }

    @Override
    public User queryById(int id) {
        return userDao.queryById(id);
    }

    @Override
    public int deleteById(int id) {
        return userDao.deleteById(id);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int modify(User user) {
        return userDao.modify(user);
    }
}
