package org.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bean.Result;
import org.dao.IResultDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class ResultTest {
    private InputStream in;
    private SqlSession session;
    private IResultDao resultDao;

    /*
     * 初始化
     * */
    @Before //用于在测试方法执行之前执行
    public void init() throws Exception{
        // 1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建一个SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        // 3.使用工厂产生的SqlSession对象
        session = factory.openSession();
//         session = factory.openSession(true); 若为true值，则将自动提交事务，不需要手动提交
        // 4.使用SqlSession创建Dao接口的代理对象
        resultDao = session.getMapper(IResultDao.class);
    }

    /*
     * 资源销毁
     * */
    @After //用于在测试方法执行之后执行
    public void destroy() throws Exception{
        // 提交事务
        session.commit();
        // 6.释放资源
        session.close();
        in.close();
    }

    @Test
    public void testFindByAss(){
       Result result = resultDao.findAllByCondition(15);
        System.out.println(result);
    }
}
