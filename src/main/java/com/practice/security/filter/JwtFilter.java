package com.practice.security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.practice.productMaintain.controller.MaintainProductController;
import com.practice.security.service.PracticeUserDetailService;
import com.practice.security.util.JwtUtil;

@Component
public class JwtFilter extends OncePerRequestFilter {
	
	private static Logger logger = LoggerFactory.getLogger(JwtFilter.class);
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private PracticeUserDetailService userDtailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// 取得 header 資訊
		String tokenHeader = request.getHeader("Authorization");
		
		// 取出來預設為 Bearer token ... etc
		String token = null;
		String userName = null;
		
		if(tokenHeader!= null && tokenHeader.startsWith("Bearer ")) {
			token = tokenHeader.substring(7);	// 排除 Bearer[空白] 這7個字元，把令牌給取出
			try {
				userName = jwtUtil.extractUsername(token);	//把 token 反解回 userName
			} catch (Exception e) {
				// 此處可能發生解析 token 回 userName時異常
				logger.error("解析token異常", e);
			}
		}

		// TODO: 這段待研究
		if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			// 利用 userName 取出使用者資訊
			UserDetails userDetails = userDtailsService.loadUserByUsername(userName);
			
			if(jwtUtil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = 
						new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities()
				);
				usernamePasswordAuthenticationToken.setDetails(
						new WebAuthenticationDetailsSource().buildDetails(request)
				);
				// After setting the Authentication in the context, we specify
				// that the current user is authenticated. So it passes the
				// Spring Security Configurations successfully.
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		
		filterChain.doFilter(request, response);
	}
	
}
