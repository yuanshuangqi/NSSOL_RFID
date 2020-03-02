package com.nssol.web.system.controller.role;

import com.nssol.model.PageParameter;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RoleRequest extends PageParameter {
    private String roleName;
}
