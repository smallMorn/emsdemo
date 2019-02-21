package com.baizhi.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Integer id;

    private String username;
    @JSONField(serialize = false)
    private String password;

    private String realname;

    private Integer sex;
    @JSONField(format = "yyyy-MM-dd")
    private Date birth;

    private String mobile;

    private String email;

    private String pic;

    private Integer deptId;


}