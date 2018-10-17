/**
 * 
 */
/**
 * @author callor
 *
 */
package com.biz.form01.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CRUD_Controller {
	
	@RequestMapping("insert_form.do")
	public String insert_form() {
		return "insert_form";
	}

}