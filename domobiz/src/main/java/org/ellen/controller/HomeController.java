package org.ellen.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.ellen.domain.MemberVO;
import org.ellen.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Inject
	private MemberService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	@RequestMapping("/index")
	public void index(){
		
	}
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public void join(){
		
	}
	
	@RequestMapping(value="/insertMember", method=RequestMethod.POST)
	public String join(MemberVO vo) throws Exception{
		
		System.out.println(vo);
		service.insertMember(vo);
		
		return "/login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void login(){
		
	}
	
	@RequestMapping(value="/accessory", method=RequestMethod.GET)
	public void accessory(){
		
	}
	
	@RequestMapping(value="/itemList", method=RequestMethod.GET)
	public void itemList(){
		
	}
}
