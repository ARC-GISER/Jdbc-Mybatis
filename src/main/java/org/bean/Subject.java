package org.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Subject implements Serializable {
    private int id; // 科目号
    private String subjectname; // 课程名
    private int classhour; // 课程时
    private int gradeid; // 年级号

    private String gname; //年级信息
}
