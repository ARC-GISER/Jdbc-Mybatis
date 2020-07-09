package org.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bean.Grade;
import org.dao.IGradeDao;
import org.dao.ISubjectDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class GradeTest {

    private InputStream in;
    private SqlSession session;
    private IGradeDao gradeDao;

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
        gradeDao = session.getMapper(IGradeDao.class);
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

    // 增加数据
    @Test
    public void testAdd(){
        Grade grade = new Grade();
        grade.setGname("研究僧");
        gradeDao.saveGrade(grade);
    }

    // 修改数据
    @Test
    public void testUpdate(){
        Grade grade = new Grade();
        grade.setGname("博士僧");
        gradeDao.updateGrade(grade);
    }

    // 删除数据
    @Test
    public void testDelete(){
        int id = 13;
        gradeDao.deleteGrade(id);
    }

    // 查找所有与数据
    @Test
    public void testFindAll(){
        List<Grade> grades = gradeDao.findAll();
        for (Grade grade:grades){
            System.out.println("-----------年级表-----------");
            System.out.println(grade);
        }
    }

    // 关联查询
    @Test
    public void testFindByCondition(){
        List<Grade> grades = gradeDao.findByCondition(5);
        for (Grade grade:grades){
            System.out.println(grade);
        }
    }
}
