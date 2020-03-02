package com.nssol.dao.master;

import java.util.List;

import com.nssol.web.system.model.RoleInfo;
import com.nssol.web.system.model.UserInfo;
import com.nssol.web.system.model.UserRoleInfo;
import com.nssol.web.system.controller.user.UserRequest;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nssol.model.UserModel;

@Mapper
public interface UserDao {
	List<UserModel> selectByCriteria(UserModel user);

	int insert(UserModel record);

	Integer editPas(@Param("oldPas") String oldPas, @Param("newPas") String newPas, @Param("userId") String userId);

	Integer restPasById(@Param("password") String password, @Param("userId") String userId);

	void insertUser(UserInfo userInfo);

	void updateUser(UserInfo userModel);

	void deleteUserRoleById(@Param("userId") String userId);

	void insertUserRole(@Param("userRoleList")List<UserRoleInfo> userRoleList);

	void delUser(@Param("userId") String userId);

	void delUserRole();

	List<UserInfo> findUser(UserRequest userRequest);

	List<RoleInfo> findRoleList(@Param("userId")String userId);

	UserInfo findUserByName(@Param("userName") String userName);
}