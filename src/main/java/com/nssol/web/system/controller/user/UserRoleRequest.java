package com.nssol.web.system.controller.user;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class UserRoleRequest implements Serializable {

    private String id;
    private Integer[] roleIds;
}
