package com.genius7.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.genius7.model.User;
import com.genius7.rule.UserRule;
import com.genius7.util.HelperValidation;
import com.genius7.util.TokenUtil;

/**
 * That is responsible for intercept the URL and check and authenticate the token sent.
 * @author Rafael Rocha
 *
 */
public class AuthenticationTokenFilter extends OncePerRequestFilter{

	/**
	 * Is not possible inject classes here so we need to create a constructor that will receive it
	 */
	private TokenUtil tokenUtil;
	private UserRule userRule;
	
	public AuthenticationTokenFilter(TokenUtil tokenUtil,UserRule userRule ) {
		this.tokenUtil = tokenUtil;
		this.userRule = userRule;
	}
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
			String token = getToken(request);
			System.out.println("Call Auth: "+token);
			boolean valid = tokenUtil.isValid(token);
			System.out.println(valid);
			if(valid) {
				authenticate(token);
			}
			filterChain.doFilter(request, response);
	}

	private void authenticate(String token) {
		//--------------------------------------------------------------------------
		//We need to tell to Spring security that this user is already authenticated
		//--------------------------------------------------------------------------
		Long userId = tokenUtil.getUserId(token);
		User user = userRule.find(userId);
		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user.getUsername(), null, user.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
		
	}
	private String getToken(HttpServletRequest request) {
		String token = request.getHeader(HttpHeaders.AUTHORIZATION);
		if(!HelperValidation.isEmpty(token)) {
			if(token.startsWith("Bearer ")) {
				return token.substring(7,token.length());
			}
		}
		return null;
	}

}
