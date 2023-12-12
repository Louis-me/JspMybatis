package xyz.shi.dao.impl;

import org.apache.ibatis.session.SqlSession;
import xyz.shi.dao.UserDao;
import xyz.shi.entity.User;

import java.util.List;
import java.util.Map;
import xyz.shi.utils.MybatisUtils;
public class UserDaoImpl implements UserDao {

    @Override
    public List<User> getUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        // 命名空间+id，这就是命名空间的作用：便于区分
        List<User> users = sqlSession.selectList("usersMapper.getUserList");
        sqlSession.close();
        return users;
    }

    @Override
    public User queryOne(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        List<User> users  = sqlSession.selectList("usersMapper.queryOne", user);
        sqlSession.close();
        if (users != null) {
             return users.get(0);
         } else {
             return null;
         }
    }

    @Override
    public User queryById(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        User user1 =  sqlSession.selectOne("usersMapper.queryById", id);
        sqlSession.close();
        return user1;
    }

    @Override
    public int deleteById(int id) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int num = sqlSession.delete("usersMapper.deleteById", id);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public int addUser(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int num = sqlSession.insert("usersMapper.addUser", user);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }

    @Override
    public int modify(User user) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        int num = sqlSession.update("usersMapper.modify", user);
        sqlSession.commit();
        sqlSession.close();
        return num;
    }
}
