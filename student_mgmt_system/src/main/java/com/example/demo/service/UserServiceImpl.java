package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao adminDao;
	
	@Override
	public User registerAdmin(User admin) {
		adminDao.save(admin);
		return admin;
	}

	@Override
	public User updateAdminDetails(Integer adminId, User admin) {
		Optional<User> opt = adminDao.findById(adminId);
		if(!opt.isPresent()) return null;
		admin.setAdminId(opt.get().getAdminId());
		adminDao.save(admin);
		return admin;
	}

}
