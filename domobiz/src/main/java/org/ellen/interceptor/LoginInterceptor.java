package org.ellen.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	private static final String LOGIN = "login";
	private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		// UserController에서 'userVO'라는 이름으로 객첼를 담아둔 상태이므로, 이 상태를 체크해서
		// HttpSession에 저장
		HttpSession session = request.getSession();

		ModelMap modelMap = modelAndView.getModelMap();
		Object memberVO = modelMap.get("memberVO");

		if (memberVO != null) {
			logger.info("new login success");
			session.setAttribute(LOGIN, memberVO);
			// response.sendRedirect("/");

			if(request.getParameter("useCookie")!=null){	//자동 로그인을 선택한 경우
				logger.info("remember me...........");
				Cookie loginCookie = new Cookie("loginCookie", session.getId());	//쿠키 생성, 값(value)으로 현재 세션의 아이디값 보관
				loginCookie.setPath("/");
				loginCookie.setMaxAge(60*60*24*7);	//일주일간 브라우저에 보관
				response.addCookie(loginCookie);	//쿠키 전송
			}
			//로그인 성공했을 때 sendRedirect 에 dest를 사용
			Object dest = session.getAttribute("dest");
			response.sendRedirect(dest != null ? (String) dest : "/");
		}

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();

		// 기존 HttpSession에 남아있는 정보가 있는 경우 정보를 삭제
		if (session.getAttribute(LOGIN) != null) {
			logger.info("clear login data before");
			session.removeAttribute(LOGIN);
		}
		return true;
	}
}