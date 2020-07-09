package org.bean;

import lombok.Data;

import java.util.List;

@Data
public class QueryVo {
    private Student student;
    private List<Integer> ids;
}
