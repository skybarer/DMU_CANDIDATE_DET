package com.hcl.dmu.config.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class JwtAuthenticationResponse {
    private String token;
    private String tokenType = "Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> role;

    public JwtAuthenticationResponse(String token, UserPrincipal userPrincipal) {
        this.token = token;
        this.username=userPrincipal.getUsername();
        this.role = userPrincipal.getAuthorities();
    }
    
    public String getToken() {
		return token;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Collection<? extends GrantedAuthority> getRole() {
		return role;
	}

	public void setRole(Collection<? extends GrantedAuthority> role) {
		this.role = role;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }
}
