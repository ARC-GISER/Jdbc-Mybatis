package org.dao;

import org.bean.Result;

import java.util.List;

public interface IResultDao {
    // 增加记录
    void saveResult(Result result);

    // 删除记录
    void deleteResult(long id);

    // 修改记录
    void updateResult(Result result);

    // 查询所有
    List<Result> findAll();

    // 关联查询
    Result findAllByCondition(long id);
}
