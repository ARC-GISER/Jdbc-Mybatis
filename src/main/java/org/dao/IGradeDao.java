package org.dao;

import org.apache.ibatis.annotations.Param;
import org.bean.Grade;

import java.util.List;
import java.util.Map;

public interface IGradeDao {

    // 增加年级信息
    void saveGrade(Grade grade);

    // 修改年级信息
    void updateGrade(Grade grade);

    // 删除年级信息
    void deleteGrade(long id);

    // 查询所有年级信息
    List<Grade> findAll();

    // 根据年级编号查询年级信息
    List<Grade>  findById(long id);

    // 关联查询
    List<Grade> findByCondition(int id);
    // 查询总记录数
    int findCount();

    // 分页查询
    List<Grade> findByLimit(@Param("pageNum") int pageNum,@Param("pageSize") int pageSzie);


}
