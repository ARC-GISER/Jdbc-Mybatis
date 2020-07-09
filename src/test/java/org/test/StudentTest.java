package org.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.bean.Student;
import org.dao.IStudentDao;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTest {
    private InputStream in;
    private SqlSession session;
    private IStudentDao studentDao;

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
        studentDao = session.getMapper(IStudentDao.class);
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

    /*查询所有学生*/
    @Test
    public void testFindAll() {
        List<Student> students = studentDao.findAll();
        for (Student stu: students) {
            System.out.println("-----------每个学生信息------------");
            System.out.println(stu);
            System.out.println(stu.getResults());
        }
    }

    /*新增学生*/
    @Test
    public void testSaveStudent(){
        Student student = new Student();
        student.setSname("周志强");
        student.setSex("妖");
        student.setTelephone("1579126783");
        student.setQq("1034712402");
        student.setWechat("1579126783");
        student.setGradeid(5);
        student.setEnterdate(java.sql.Date.valueOf("2020-03-18"));
        student.setFromcity("合肥");
        student.setBirthday(java.sql.Date.valueOf("1997-05-12"));
        student.setAddress("安徽合肥滨湖新区滨湖世纪城");
        student.setPass("456456");
        student.setIdcardpic("340123199705120305");
        studentDao.saveStudent(student);

    }

    // 删除学生
    @Test
    public void testDeleteStudent(){
        int id = 208;
        studentDao.deleteStudent(id);
    }

    // 按姓名、qq、wechat模糊查询并分页
    @Test
    public void testFindByCondition(){
        int currentPage = 2;
        int pageSize = 5;
        Map<String,Object> map = new HashMap<>();
        map.put("sname","张");
        map.put("qq",4);
        map.put("wechat",6);
        map.put("pageNum",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);
        List<Student> students = studentDao.findByCondition(map);
        for (Student student:students){
            System.out.println("--------模糊查询--------");
            System.out.println(student);
        }
    }

    // 按姓名、qq、wechat模糊查询学生数量
    @Test
    public void testFindByCondition2(){
        Map<String,Object> map = new HashMap<>();
        map.put("sname","张");
        map.put("qq",45);
        map.put("wechat",66);
        int count = studentDao.findByCondition2(map);
        System.out.println("查询学生总数为："+count);
    }



}
