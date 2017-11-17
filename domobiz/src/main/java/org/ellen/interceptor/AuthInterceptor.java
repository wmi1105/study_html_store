package org.ellen.interceptor;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.ellen.domain.MemberVO;
import org.ellen.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

	@Inject
	private MemberService service;

	// 사용자가 원래 가려고 했던 URI를 저장했다가 로그인 후 이동
	private void saveDest(HttpServletRequest req) {
		String uri = req.getRequestURI();
		String query = req.getQueryString();
		if (query == null || query.equals("null")) {
			query = "";
		} else {
			query = "?" + query;
		}

		// GET방식인 경우 URI뒤의 파라미터들을 모두 보관
		if (req.getMethod().equals("GET")) {
			logger.info("dest: " + (uri + query));
			req.getSession().setAttribute("dest", uri + query);
		}
	}

	// 현재 사용자가 로그인한 상태인지를 체크하고, 컨트롤러를 호출하게 할 것인지를 결정
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();

		// 로그인하지 않았을 경우
		if (session.getAttribute("login") == null) {
			logger.info("current user is not logined");
			saveDest(request);

			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			
			//현재 사용자가 세션에 적당한 값이 없는 경우 loginCookie를 가지고 있는지 체크
			if (loginCookie != null) {
				MemberVO memberVO=service.checkLoginBefore(loginCookie.getValue());
				logger.info("MEMBERVO: "+memberVO);
				
				//과거에 보관한 쿠키가 있다면 UserService 객체를 통해 사용자의 정보가 존재하는지 확인
				if(memberVO != null){
					session.setAttribute("login", memberVO);	//정보가 존재한다면 세션에 다시 사용자의 정보를 넣어줌
					return true;
				}

			}
			response.sendRedirect("/login");
			return false;
		}
		return true;
	}

}
