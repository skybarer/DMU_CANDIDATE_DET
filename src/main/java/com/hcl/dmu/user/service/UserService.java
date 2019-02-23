package com.hcl.dmu.user.service;

import java.util.List;

import com.hcl.dmu.user.vo.RolesVo;
import com.hcl.dmu.user.vo.UserVo;

public interface UserService {

	boolean login(UserVo userVo);

	List<RolesVo> roles();
}
