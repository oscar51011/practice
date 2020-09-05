package com.practice.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.practice.security.dao.UserDao;

/**
 * Spring Security 用來載入 使用者資訊的 Component
 * @author 林聖凱
 *
 */
@Service
public class PracticeUserDetailService implements UserDetailsService {

	@Autowired
	private UserDao userDao;
	
	/**
	 * TODO: 可以改成進DB撈取資料 
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		com.practice.model.User user = userDao.getUserByUserName(username);
		if(user == null) throw new UsernameNotFoundException("系統無此用戶資訊: " + username);
		
		/**
		 * TODO: roles一定要給，不然會有異常錯誤發生
		 * 原因: Cannot pass a null GrantedAuthority collection
		 */
		UserDetails userDetails = User.builder()
                .username(user.getUserName())
                .password("{noop}"+user.getPassword()) // {noop}為了讓顯示不先加密
                .roles("user")
                .build();
		
		return userDetails;
	}
	
}
