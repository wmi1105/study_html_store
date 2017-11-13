package org.ellen.service;

import javax.inject.Inject;

import org.ellen.domain.MemberVO;
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

}
