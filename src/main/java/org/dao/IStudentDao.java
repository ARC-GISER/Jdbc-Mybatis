package org.dao;

import org.bean.QueryVo;
import org.bean.Student;

import java.util.List;
import java.util.Map;

public interface IStudentDao {
    /*
    * 查询所有的操作
    * */
    List<Student> findAll();

    /*
    * 保存学生信息（添加学生信息）
    * */
    void saveStudent(Student student);

    /*
    * 更新学生信息
    * */
    void updateStudent(Student student);

    /*
    * 删除学生信息
    * */
    void deleteStudent(Integer studentId);

    /*
    * 查询一条数据
    * */
    Student findById(long stuId);

    /*
    * 模糊查询
    * */
    //List<Student> findByName(String stuName);
    List<Student> findByCondition(Map<String,Object> map);

    int findByCondition2(Map<String,Object> map);

    /*
    * 查询学生总数
    * */
    int findTotal();

    /*
    * 根据queryVo 中的条件查询用户
    * */
    List<Student> findStudentByVo(QueryVo vo);

    /*
    * 根据传入的参数条件
    * */
    List<Student> findStudentByCondition(Student student);

    /*
    * 根据queryVo中的id集合，查询学生信息
    * */
    List<Student> findUserInIds(QueryVo vo);
}
