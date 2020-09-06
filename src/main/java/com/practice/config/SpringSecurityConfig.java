package com.practice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.practice.security.filter.JwtFilter;
import com.practice.security.service.PracticeUserDetailService;
import com.practice.security.util.CustomAuthenticationEntryPoint;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PracticeUserDetailService userDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Autowired
	private CustomAuthenticationEntryPoint customAuthenticationEntryPoint;
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	} 
	
	/**
	 * 自定義 取得 使用者資訊的實作
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	
	/**
	 * 部分資源可以繞過 spring security
	 */
	@Override
	public void configure(final WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
		web.ignoring().antMatchers("/h2-console/**");
	}

	
	/**
	 * 讓 /api 開頭的 request 需要做 JWT Token 認證
	 * 
	 * TODO: 要改成所有的頁面都需要認證 & 只有 /login or /authenticate 允許登入
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// 針對 api url 要做認證
		http.csrf().disable()
			.authorizeRequests() //設置認證機制
			.antMatchers("/authenticate").permitAll()	//取得token URL不需認證
			.antMatchers("/api/**").authenticated()		//針對 api系列的 URL需要認證
			.and()
			.exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint)
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
			;
			
			/*
			 * TODO: 後期方向應該會長這樣
			 * https://polinwei.com/spring-customize-securing-web/
			 * 
			http.csrf().disable()
			.authorizeRequests() //設置認證機制
			.antMatchers("/login").permitAll()
			.antMatchers("/authenticate").permitAll()
			.anyRequest().authenticated()
			.and()
			.exceptionHandling().authenticationEntryPoint(customAuthenticationEntryPoint)
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
			;
			*/	
	}
	
	
	
}
