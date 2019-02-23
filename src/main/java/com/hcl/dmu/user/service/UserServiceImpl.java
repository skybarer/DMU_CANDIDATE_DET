package com.hcl.dmu.user.service;

import java.util.List; 

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.dmu.user.dao.UserDao;
import com.hcl.dmu.user.vo.RolesVo;
import com.hcl.dmu.user.vo.UserVo;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public boolean login(UserVo userVo) {
		return userDao.login(userVo);
	}

@Override
	public List<RolesVo> roles() {
		return userDao.roles();
	}

}
