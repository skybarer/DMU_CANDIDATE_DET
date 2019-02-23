package com.hcl.dmu.user.dao;

import java.util.List;

import com.hcl.dmu.user.vo.RolesVo;
import com.hcl.dmu.user.vo.UserVo;

public interface UserDao {

	public boolean login(UserVo userVo);
	public List<RolesVo> roles();
	public UserVo findByEmail(String usernameOrEmail);
}
