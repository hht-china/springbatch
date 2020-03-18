package com.example.demo.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
public class SysLog implements Serializable {
    private static final long serialVersionUID = 1L;

    private String username;

    private String operation;

    private String method;

    private String params;

    private String ip;

    private String resp;

    private Date createDate;


}