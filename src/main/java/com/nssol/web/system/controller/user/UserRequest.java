package com.nssol.web.system.controller.user;

import com.nssol.model.PageParameter;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest extends PageParameter {
    private String account;
    private Long roleId;
}
