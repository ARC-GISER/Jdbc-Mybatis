package org.dao;

import org.bean.Subject;

import java.util.List;
import java.util.Map;

public interface ISubjectDao {
   /*
   * 查询所有的操作
   * */
   List<Subject> findAll();
   Subject findAllByCondition(long id);
   /*
   * 查询单条数据
   * */
   Subject findById(long id);

   /*
   * 分页查询
   * */
   List<Subject> findSubjectByLimit(Map<String,Object> map);

   /*
   * 模糊查询(根据科目名称)
   * */
   List<Subject> findByName(String name);

   /*
   * 查询总记录数
   * */
   int findTotal();

   /*
   * 增加数据
   * */
   void saveSubject(Subject subject);

   /*
   * 修改数据
   * */
   void updateSubject(Subject subject);

   /*
   * 删除数据
   * */
   void deleteSubject(long id);

   // 按年级查询信息
   List<Subject> findByGradeId(int id);
}
