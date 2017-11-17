package org.ellen.service;

import java.util.Date;

import javax.inject.Inject;

import org.ellen.domain.MemberVO;
import org.ellen.dto.LoginDTO;
import org.ellen.persistence.MemberDAO;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	private MemberDAO dao;
	
	@Override
	public void insertMember(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		dao.insertMember(vo);
	}

	@Override
	public MemberVO login(LoginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(dto);
	}

	@Override
	public void keepLogin(String id, String sessionId, Date next) throws Exception {
		// TODO Auto-generated method stub
		dao.keepLogin(id, sessionId, next);
	}

	@Override
	public MemberVO checkLoginBefore(String value) {
		// TODO Auto-generated method stub
		return dao.checkLoginBefore(value);
	}

}
