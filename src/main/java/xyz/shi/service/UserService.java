package xyz.shi.service;

import xyz.shi.entity.User;

import java.util.List;
public interface UserService {
    List<User> getUserList();
    User queryOne(User user);
    User queryById(int id);
    int deleteById(int id);
    int addUser(User user);
    int modify(User user);

}
