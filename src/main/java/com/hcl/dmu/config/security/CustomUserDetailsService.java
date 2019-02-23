package com.hcl.dmu.config.security;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hcl.dmu.user.dao.UserDao;
import com.hcl.dmu.user.vo.UserVo;

@Transactional
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail)
            throws UsernameNotFoundException {
        UserVo user = userDao.findByEmail(usernameOrEmail);
        if(user == null){
        	new UsernameNotFoundException("User not found with username or email : " + usernameOrEmail);
        }
        return UserPrincipal.create(user);
    }
}
