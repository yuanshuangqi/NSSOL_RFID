package com.nssol.dao.master;


import com.nssol.web.system.controller.menu.MenuRequest;
import com.nssol.web.system.model.MenuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface MenuDao {

	void save(MenuInfo menuInfo);

	List<MenuInfo> findMenu(MenuRequest menuRequest);

	void deleteMenu(@Param("id") Long id);

	void deleteRoleMenu();

	List<MenuInfo> findByParentId(@Param("id")Long id);

	void update(MenuInfo menuInfo);
}