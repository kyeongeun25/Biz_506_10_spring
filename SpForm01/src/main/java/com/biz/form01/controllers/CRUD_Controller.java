/**
 * 
 */
/**
 * @author callor
 *
 */
package com.biz.form01.controllers;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.form01.dao.MemberDAO;
import com.biz.form01.vo.MemberVO;

@Controller
public class CRUD_Controller {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("insert_form.do")
	public String insert_form(Model model) {
		return "insert_form";
	}
	
	@RequestMapping("insert_ok.do")
	public String insert_ok(
			@ModelAttribute MemberVO vo,Model model) {
		
		MemberDAO dao 
		= sqlSession.getMapper(MemberDAO.class);
		
		if(vo.getId() > 0) {
			dao.update(vo);
		} else {
			dao.insert(vo);	
		}
		model.addAttribute("MEMBER",vo);
		
		// return 문자열에 redirect: 이 선행하면
		// view를 보이라는 것이 아니고
		// req를 view_list.do 로 넘겨라
		return "redirect:view_list.do" ;
		
	}
	
	@RequestMapping("view_list.do")
	public String viewList(Model model) {
		
		MemberDAO dao
		= sqlSession.getMapper(MemberDAO.class);
		List<MemberVO> memberList = dao.selectAll();
		model.addAttribute("MEMBERS",memberList);
		return "view_list" ;
		
	}
	
	@RequestMapping("update.do")
	public String update(Model model, 
			@RequestParam int id) {
		
		MemberDAO dao
		= sqlSession.getMapper(MemberDAO.class);
		MemberVO vo = dao.selectOne(id);
		
		model.addAttribute("MEMBER",vo);
		return "insert_form";
		
	}
	
	@RequestMapping("delete.do")
	public String delete(@RequestParam int id) {
		MemberDAO dao = sqlSession.getMapper(MemberDAO.class);
		dao.delete(id);
		return "redirect:view_list.do";
	}

}