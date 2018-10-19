package com.biz.memo01.controllers;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biz.memo01.dao.MemberDAO;
import com.biz.memo01.vo.MemberVO;

@Controller
public class MemberController {

	@Autowired
	SqlSession sqlSession;
	
	@RequestMapping("join.member")
	public String join(Model model) {
		model.addAttribute("BODY","JOIN_FORM");
		return "home";
	}
	
	@RequestMapping("join_ok.member")
	public String join_ok(Model model, @ModelAttribute MemberVO vo) {
		
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		dao.insert(vo);
		return "redirect:home.memo";
		
	}
}
