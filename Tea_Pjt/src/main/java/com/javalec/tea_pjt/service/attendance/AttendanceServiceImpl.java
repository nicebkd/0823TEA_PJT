package com.javalec.tea_pjt.service.attendance;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.javalec.tea_pjt.model.attendance.dao.AttendanceDAO;

@Service
public class AttendanceServiceImpl implements AttendanceService{
	
	@Inject
	AttendanceDAO aDao;

	@Override
	public int attendance(String user_id) {
		return aDao.attendance(user_id);
	}
}
