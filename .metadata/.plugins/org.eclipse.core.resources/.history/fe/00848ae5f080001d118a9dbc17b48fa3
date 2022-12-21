package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminDao;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	@Override
	public Admin registerAdmin(Admin admin) {
		adminDao.save(admin);
		return admin;
	}

	@Override
	public Admin updateAdminDetails(Integer adminId, Admin admin) {
		Optional<Admin> opt = adminDao.findById(adminId);
		if(!opt.isPresent()) return null;
		admin.setAdminId(opt.get().getAdminId());
		adminDao.save(admin);
		return admin;
	}

}
