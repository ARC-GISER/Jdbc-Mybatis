package org.bean;

import lombok.Data;

import java.sql.Date;

@Data
public class Result {
    private long id;
    private Date exam_date;
    private float score;
    private long st_id;
    private int sb_id;

    // 关联学生实体类
    private Student stu;
    // 关联学科实体信息
    private Subject sub;
}
