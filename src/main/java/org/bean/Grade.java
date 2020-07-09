package org.bean;

import lombok.Data;

import java.util.List;

@Data
public class Grade {
    private int id; // 年级id
    private String gname; // 年级名称

    private List<Subject> sub;
}
