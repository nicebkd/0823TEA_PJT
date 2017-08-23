package com.javalec.tea_pjt.model.attendance.dto;

import java.util.Date;

public class AttendanceDTO {
	private String user_id;
	private Date atDate;
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public Date getAtDate() {
		return atDate;
	}
	public void setAtDate(Date atDate) {
		this.atDate = atDate;
	}
}
