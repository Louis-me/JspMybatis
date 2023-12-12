package xyz.shi.dao;

import xyz.shi.entity.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface UserDao {
    List<User> getUserList();
    User queryOne(User user);
    User queryById(int id);
    //    //通过id删除用户
    int deleteById(@Param("id")int id);
    int addUser(User user);

    int modify(User user);

}
