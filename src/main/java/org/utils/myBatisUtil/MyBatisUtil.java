package org.utils.myBatisUtil;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.dao.IStudentDao;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        // 1.读取配置文件
        InputStream in = null;
        SqlSession session = null;
        try {
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            // 2.创建一个SqlSessionFactory工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = builder.build(in);
            // 3.使用工厂产生的SqlSession对象
            session = sqlSessionFactory.openSession();
//         session = factory.openSession(true); 若为true值，则将自动提交事务，不需要手动提交
            // 4.使用SqlSession创建Dao接口的代理对象
            IStudentDao studentDao = session.getMapper(IStudentDao.class);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


}
