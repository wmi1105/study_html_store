package org.ellen.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.ellen.domain.MemberVO;
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
}
