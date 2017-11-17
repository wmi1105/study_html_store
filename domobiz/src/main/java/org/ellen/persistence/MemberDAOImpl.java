package org.ellen.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.ellen.domain.MemberVO;
import org.ellen.dto.LoginDTO;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Inject
	private SqlSession session;
	
	private static String namespace = "org.ellen.mapper.MemberMapper";
	
	@Override
	public void insertMember(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".insertMember", vo);
	}

	@Override
	public MemberVO login(LoginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".login", dto);
	}

	@Override
	public void keepLogin(String id, String sessionId, Date next) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		paramMap.put("sessionId", sessionId);
		paramMap.put("next", next);
		
		session.update(namespace+".keepLogin", paramMap);
	}

	@Override
	public MemberVO checkLoginBefore(String value) {
		// TODO Auto-generated method stub
		return  session.selectOne(namespace+".checkUserWithSessionKey", value);
	}
}
