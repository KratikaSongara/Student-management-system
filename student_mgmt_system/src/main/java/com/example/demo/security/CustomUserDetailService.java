package com.example.demo.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserDao;

@Service
public class CustomUserDetailService implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
		User user = userDao.findByMobile(mobile);
		if(user == null) return null;
		return new CustomUserDetails(user);
	}
}
