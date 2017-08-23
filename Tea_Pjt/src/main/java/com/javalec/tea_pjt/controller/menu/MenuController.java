package com.javalec.tea_pjt.controller.menu;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javalec.tea_pjt.controller.member.MemberController;
import com.javalec.tea_pjt.model.member.dto.MemberDTO;
import com.javalec.tea_pjt.service.attendance.AttendanceService;
import com.javalec.tea_pjt.service.member.MemberService;

@Controller
@RequestMapping("/menu/*")
public class MenuController {

	private static final Logger logger
	=LoggerFactory.getLogger(MenuController.class);
	
	@Inject
	AttendanceService aService;
	@Inject
	MemberService mService;
	
	@RequestMapping("brand/introduceGongcha.do")
	public String IntroduceGongcha() {
		return "/menu/brand/introduceGongcha";
	}
	
	@RequestMapping("event/attendanceGo.do")
	public String AttendanceGo() {
		return "/menu/event/attendance";
	}
	@RequestMapping("attendance")
	public ModelAndView Attendance(ModelAndView mav, HttpSession session){
		MemberDTO dto = (MemberDTO) session.getAttribute("user");
		String user_id = dto.getUser_id();
		//날짜비교 메소드만들어서 비교한 다음 오늘 날짜와 일치하면 출석 완료해야함!!!!!!!!!!
		int result = aService.attendance(user_id);
		if(result >= 1){
			mav.addObject("msg", "출석완료!");
			mav.setViewName("/menu/event/attendance");
		}else{
			mav.addObject("msg", "출석체크를 할 수 없습니다.");
			mav.setViewName("/menu/event/attendance");
		}
		return mav;
	}
}
