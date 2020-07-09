package org.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bean.Student;
import org.bean.Subject;
import org.dao.ISubjectDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubjectTest {

    private InputStream in;
    private SqlSession session;
    private ISubjectDao subjectDao;

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
        subjectDao = session.getMapper(ISubjectDao.class);
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

    // 查询所有数据
    /*@Test
    public void testFindAll(){
        List<Subject> subjects = subjectDao.findAll();
        for (Subject s:subjects){
            System.out.println("----------科目表---------");
            System.out.println(s);
        }
    }*/

    // 增加数据
    @Test
    public void testSaveSubject(){
        Subject subject = new Subject();
        subject.setSubjectname("R语言入门");
        subject.setClasshour(42);
        subject.setGradeid(2);
        subjectDao.saveSubject(subject);
    }

    // 修改数据
    @Test
    public void testUpdateSubject(){
        Subject subject = new Subject();
        subject.setId(55);
        subject.setSubjectname("ArcGIS入门");
        subject.setClasshour(46);
        subject.setGradeid(3);
        subjectDao.updateSubject(subject);
        System.out.println(subject);
    }

    // 删除数据
    @Test
    public void testDeleteSubject(){
        long id = 55;
        subjectDao.deleteSubject(id);
    }

    // 查询单条数据
    @Test
    public void testFindById(){
        long id = 22;
        Subject subject = subjectDao.findById(id);
        System.out.println(subject);
    }

    // 按年级查询信息
    @Test
    public void testFindByGradeId(){
        List<Subject> subjects = subjectDao.findByGradeId(5);
        for (Subject subject:subjects){
            System.out.println(subject);
        }
    }
    // 模糊查询
    @Test
    public void testFindByName(){
        List<Subject> subjects = subjectDao.findByName("java");
        for (Subject s:subjects){
            System.out.println(s);
        }
    }

    // 查询总数
    @Test
    public void testFindTotal(){
        int count = subjectDao.findTotal();
        System.out.println("查询总数为："+count);
    }

    // 分页查询
    @Test
    public void testFindByPage(){
        int currentPage = 2;
        int pageSize = 5;
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("startIndex",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Subject> subjecsByLimit = subjectDao.findSubjectByLimit(map);
        for (Subject s:subjecsByLimit){
            System.out.println(s);
        }
    }

    @Test
    public void test01(){
        Subject subject = subjectDao.findAllByCondition(1);
        System.out.println(subject);
    }
}
