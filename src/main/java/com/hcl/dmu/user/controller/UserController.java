package com.hcl.dmu.user.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hcl.dmu.config.security.JwtAuthenticationResponse;
import com.hcl.dmu.config.security.JwtTokenProvider;
import com.hcl.dmu.config.security.UserPrincipal;
import com.hcl.dmu.reg.vo.ResponseVO;
import com.hcl.dmu.user.service.UserService;
import com.hcl.dmu.user.vo.RolesVo;
import com.hcl.dmu.user.vo.UserVo;

@Controller
@CrossOrigin(allowedHeaders={"*"})
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;
    
	@PostMapping(value = "/login")
	@ResponseBody
	public ResponseVO login(@RequestBody UserVo userVo,HttpServletResponse response) {

		ResponseVO responseVO = new ResponseVO();
		Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                		userVo.getUsername(),
                		userVo.getPassword()
                )
        );
		if(authentication!=null && authentication.getAuthorities()!=null && userVo!=null && userVo.getRole()!=null){
			List<? extends GrantedAuthority> authorities = new ArrayList<>(authentication.getAuthorities());
			if(!userVo.getRole().getRoleName().equalsIgnoreCase(authorities.get(0).getAuthority())){
				responseVO.setMessage("Role does not match");
				responseVO.setCode("403");
				response.setStatus(403);
				return responseVO;
			}
		}

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        responseVO.setCode("200");
        UserPrincipal userPrincipal = (UserPrincipal) authentication.getPrincipal();
        responseVO.setMessage(new JwtAuthenticationResponse(jwt,userPrincipal));
        return responseVO;
	}

	@GetMapping(value = "/roles")
	@ResponseBody
	public ResponseVO roles() {

		ResponseVO responseVO = null;
		List<RolesVo> roles = userService.roles();
		try {
			responseVO = new ResponseVO();
			if (roles != null) {
				responseVO.setMessage(roles);
				responseVO.setCode("200");
			} else {
				responseVO.setMessage("roles does not exit");
				responseVO.setCode("401");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return responseVO;

	}
}
