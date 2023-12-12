package xyz.shi.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {

    //sqlSession工厂
    private static SqlSessionFactory sqlSessionFactory;

    //静态代码块，直接项目跑起来直接装载
    static {
        //设置要读取的资源路径
        String resource = "mybatis-config.xml";
        //声明一个输入流，方便后面读取
        InputStream inputStream = null;

        try {
            //通过ibatis包下的资源读取的方法，通过提前设定好的路径将mybatis的核心配置文件读取进来，用来建造工厂
            inputStream = Resources.getResourceAsStream(resource);
            //new一个建造者，通过建造者创建一个带核心配置文件的工厂
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //通过工厂打开一个对数据库的会话
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}
