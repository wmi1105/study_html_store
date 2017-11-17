package org.ellen.service;

import java.util.Date;

import org.ellen.domain.MemberVO;
import org.ellen.dto.LoginDTO;

public interface MemberService {

	public void insertMember(MemberVO vo) throws Exception;

	public MemberVO login(LoginDTO dto) throws Exception;

	public void keepLogin(String id, String sessionId, Date next) throws Exception;

	public MemberVO checkLoginBefore(String value);
}
