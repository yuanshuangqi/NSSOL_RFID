package com.nssol.web.system.service.role;


import com.nssol.web.common.vo.R;
import com.nssol.web.system.model.RoleInfo;
import com.nssol.web.system.controller.role.RoleMenuRequest;
import com.nssol.web.system.controller.role.RoleRequest;

public interface IRoleService {
    R addRole(RoleInfo roleInfo);

    R editRole(RoleInfo roleInfo);

    R getRoleData(RoleRequest roleRequest);

    R delRoleById(Long id);

    R getList();

    R menuAssign(RoleMenuRequest roleMenuRequest);
}
