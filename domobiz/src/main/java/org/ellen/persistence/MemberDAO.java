package org.ellen.persistence;

import java.util.Date;

import org.ellen.domain.MemberVO;
import org.ellen.dto.LoginDTO;

public interface MemberDAO {

	public void insertMember(MemberVO vo) throws Exception;		//회원 등록

	public MemberVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(String id, String sessionId, Date next) throws Exception;
	
	public MemberVO checkLoginBefore(String value);
}
