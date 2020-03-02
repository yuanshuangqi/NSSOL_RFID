package com.nssol.dao.master;


import com.nssol.web.system.model.MenuInfo;
import com.nssol.web.system.model.RoleInfo;
import com.nssol.web.system.model.RoleMenuInfo;
import com.nssol.web.system.controller.role.RoleRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface RoleDao {

	void save(RoleInfo roleInfo);

	List<RoleInfo> findRole(RoleRequest roleRequest);

	void deleteRole(@Param("id") Long id);

	void deleteUserRole();

	List<RoleInfo> findByParentId(@Param("id") Long id);

	void update(RoleInfo roleInfo);

	void deleteRoleMenuById(@Param("id") Integer id);

	void insertRoleMenu(@Param("roleMenuInfoList") List<RoleMenuInfo> roleMenuInfoList);

	List<MenuInfo> findMenuList(@Param("id") Long id);
}