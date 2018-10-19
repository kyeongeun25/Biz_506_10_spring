package com.biz.memo01.controllers;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.biz.memo01.dao.MemoDAO;
import com.biz.memo01.vo.MemoInfoVO;
import com.biz.memo01.vo.MemoVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MemoController {
	
	// bean에서 생성한 sqlSession을 사용하기 위해서
	// 자동으로 선언, 생성하는 Annotation
	// 자바에 @Inject와 비슷한 기능의 스프링의 Annotaion
	@Autowired
	SqlSession sqlSession ;
	
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
		
		MemoDAO dao = sqlSession.getMapper(MemoDAO.class);
		// List<MemoVO> memos = dao.selectAll();
		
		List<MemoInfoVO> memos = dao.selectInfoAll();
		
		for(MemoInfoVO vo : memos) {
			logger.info("VO",vo.toString());	
		}
		
		
		model.addAttribute("MEMOS",memos);
		model.addAttribute("BODY","LIST");
		return "home";
	}
	
	@RequestMapping("write.memo")
	public String write_memo(Model model) {
		
		model.addAttribute("BODY","WRITE");
		return "home";

	}

	
	@RequestMapping("write_ok.memo")
	public String write_ok(Model model, @ModelAttribute MemoVO vo) {

		MemoDAO dao = sqlSession.getMapper(MemoDAO.class);

		if(vo.getId() > 0) {
			dao.update(vo);
		} else {
			dao.insert(vo);	
		}
		
		model.addAttribute("BODY", "MEMO_VIEW");
		model.addAttribute("MEMO",vo);
		
		return "redirect:home.memo";
		
	}
	
	@RequestMapping("view.memo")
	public String view_memo(Model model, @RequestParam int id) {
		
		MemoDAO dao = sqlSession.getMapper(MemoDAO.class);
		MemoVO vo = dao.selectOne(id);
		
		model.addAttribute("MEMO",vo);
		model.addAttribute("BODY","WRITE");
		return "home";
		
	}
	
	@RequestMapping("delete.memo")
	public String delete_memo(Model model, @RequestParam int id) {
		
		MemoDAO dao = sqlSession.getMapper(MemoDAO.class);
		dao.delete(id);
		return "redirect:home.memo";
	}
	
}
