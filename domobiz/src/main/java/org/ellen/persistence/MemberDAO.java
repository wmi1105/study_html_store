package org.ellen.persistence;

import org.ellen.domain.MemberVO;

public interface MemberDAO {

	public void insertMember(MemberVO vo) throws Exception;		//회원 등록
}
