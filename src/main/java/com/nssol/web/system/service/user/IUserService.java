package com.nssol.web.system.service.user;


import com.nssol.model.SecurityUser;
import com.nssol.web.common.vo.R;
import com.nssol.web.system.model.UserInfo;
import com.nssol.web.system.controller.user.UserPasswordRequest;
import com.nssol.web.system.controller.user.UserRequest;
import com.nssol.web.system.controller.user.UserRoleRequest;

public interface IUserService {
    /**
     * 新增人员
     */
    R addUser(UserInfo userInfo);
    /**
     * 修改人员
     */
    R editUser(UserInfo userInfo);
    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return R
     */
    R getUserInfoByUsername(String username);

    R getUserData(UserRequest userRequest);

    R delUserByUserId(String id);

    R userRoleAssign(UserRoleRequest userRoleRequest);

    SecurityUser getUserRolesByUsername(String username);

    R updateUserPwd(UserPasswordRequest userPasswordRequest);

    R resetUserPassword(String userId);
}
