/**
 * 
 */
/**
 * @author callor
 *
 */
package com.biz.form01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.biz.form01.vo.MemberVO;

@Controller
public class CRUD_Controller {
	
	@RequestMapping("insert_form.do")
	public String insert_form(Model model) {
		return "insert_form";
	}
	
	@RequestMapping("insert_ok.do")
	public String insert_ok(
			@ModelAttribute MemberVO vo,Model model) {
		
		model.addAttribute("MEMBER",vo);
		return "view_member" ;
		
	}
}