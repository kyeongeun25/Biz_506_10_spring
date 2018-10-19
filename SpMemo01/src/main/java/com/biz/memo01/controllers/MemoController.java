package com.biz.memo01.controllers;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.biz.memo01.vo.MemoVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemoController {
	
	private static final Logger logger = LoggerFactory.getLogger(MemoController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "home.memo", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);

		// Java 1.8 이상에서 사용할수 있는 날짜 클래스
		LocalDate localDate = LocalDate.now();
		LocalDateTime localDateTime = LocalDateTime.now();
		LocalTime localTime = LocalTime.now();
		
		model.addAttribute("serverTime", localDate.toString());
		return "home";
	}
	
	@RequestMapping("write.memo")
	public String write_memo(Model model) {
		
		model.addAttribute("BODY","WRITE");
		return "home";

	}

	
	@RequestMapping("write_ok.memo")
	public String write_ok(Model model, @ModelAttribute MemoVO vo) {

		model.addAttribute("BODY", "MEMO_VIEW");
		model.addAttribute("MEMO",vo);
		return "home";
		
	}
}
