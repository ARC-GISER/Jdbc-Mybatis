package org.bean;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@Data
public class Student implements Serializable {
    private long stuno; // 学号
    private String sname; //姓名
    private String sex; //性别
    private String telephone; // 手机号
    private String qq; // qq号
    private String wechat; // 微信号
    private int gradeid; //年级号
    private Date enterdate; //入学日期
    private String fromcity; //来自城市
    private Date birthday; //生日
    private String address; //住址
    private String pass; //密码
    private String idcardpic; //身份证号

    private List<Result> results;

}
