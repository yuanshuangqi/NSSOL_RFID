package com.nssol.web.system.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter

public class UserInfo extends BaseInfo {


    private String id;// ID

    private String account;// 账号

    private String password;//密码

    private String phone;//电话号码

    private int sex;//性别

    private  String iCCard;//ICCard

    private  String deleter;//删除者

    private Date deleteTime ;

    private  String realName;//用户名

    private  String roleCode;//角色Code


    private List<RoleInfo> roles = new ArrayList<>();

    private List<MenuInfo> treeMenus;

    private List<MenuInfo> allMenus;


}
