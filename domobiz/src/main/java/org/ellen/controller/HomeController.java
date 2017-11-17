package org.ellen.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ellen.domain.MemberVO;
import org.ellen.dto.LoginDTO;
import org.ellen.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

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
		
		return "/index";
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
	public void loginGET(@ModelAttribute("dto") LoginDTO dto){
		
	}
	
	@RequestMapping(value="/loginPost", method=RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception{
		logger.info("LOGIN: "+dto);
		
		//객체에 사용자가 존재하는 경우 userVO로 저장
		MemberVO vo = service.login(dto);
		
		if(vo == null){
			return;
		}
		
		model.addAttribute("memberVO", vo);
		
		//사용자가 자동로그인을 선택한 경우
		if(dto.isUseCookie()){
			int amount=60*60*24*7;
			Date sessionLimit = new Date(System.currentTimeMillis()+(1000*amount));
			service.keepLogin(vo.getId(), session.getId(), sessionLimit);
//			loginCookie 값이 유지되는 시간 정보를 데이터베이스에 저장하는 것이 핵심
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws Exception{
		//로그아웃 처리
		String message1 = null, message2 = null;
		Object obj = session.getAttribute("login");

		//세션에 로그인 정보가 있을 경우
		//저장된 정보를 삭제하고 invalidate()를 주는 작업과 쿠키의 유효시간을 변경
		if(obj != null){
			MemberVO vo = (MemberVO) obj;
			
			session.removeAttribute("login");
			session.invalidate();
			
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			message1 = "delete login session";
			//쿠키에 정보가 남아있는 경우 데이터베이스 갱신
			if(loginCookie != null){
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin(vo.getId(), session.getId(), new Date());
				message2 = "update databases";
			} 
		}
		System.out.println(message1+" - "+message2+" - "+"LOGOUT SUCCESS");
		return "/index";
	}
	
	@RequestMapping(value="/accessory", method=RequestMethod.GET)
	public void accessory(){
		
	}
	
	@RequestMapping(value="/itemList", method=RequestMethod.GET)
	public void itemList(){
		
	}
}
