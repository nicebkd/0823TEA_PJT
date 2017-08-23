package com.javalec.tea_pjt.model.attendance.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class AttendanceDAOImpl implements AttendanceDAO{
	
	@Inject
	SqlSession sqlSession;//DB접속처리

	@Override
	public int attendance(String user_id) {
		return sqlSession.insert("attendance.insert", user_id);
	}
}
