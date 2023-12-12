package xyz.shi;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import xyz.shi.entity.User;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
public class CRUDTest {
    public static void main(String[] args) throws IOException {
        //1. 加载mybatis的核心配置文件，获取 SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //3. 执行sql (只有这块需要手写，其他步骤直接复制)
        List<User> users = sqlSession.selectList("usersMapper.selectusersAll"); // 命名空间+id，这就是命名空间的作用：便于区分
//        System.out.println(users);
        for(User user: users) {
            System.out.println(user.getId());
            System.out.println(user.getName());
            System.out.println(user.getPassword());
        }

        // 插入
        User user1 = new User();
        user1.setName("haha");
        user1.setPassword("111111");
        sqlSession.insert("usersMapper.insertusers", user1);
        sqlSession.commit();

        // 修改
        User user2 = new User();
        user2.setId(1);
        user2.setName("haha");
        user2.setPassword("111111");
        sqlSession.update("usersMapper.updateusersById", user2);
        sqlSession.commit();

        //删除
        User user3= new User();
        user3.setId(24);
        sqlSession.delete("usersMapper.deleteusersById", user3);
        sqlSession.commit();


        //4. 释放资源
        sqlSession.close();
    }

}
