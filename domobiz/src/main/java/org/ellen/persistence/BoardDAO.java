package org.ellen.persistence;

import java.util.List;

import org.ellen.domain.BoardVO;
import org.ellen.domain.Criteria;
import org.ellen.domain.SearchCriteria;

public interface BoardDAO {

  public void create(BoardVO vo) throws Exception;

  public BoardVO read(Integer bno) throws Exception;

  public void update(BoardVO vo) throws Exception;

  public void delete(Integer bno) throws Exception;

  public List<BoardVO> listAll() throws Exception;

  public List<BoardVO> listPage(int page) throws Exception;

  public List<BoardVO> listCriteria(Criteria cri) throws Exception;

  public int countPaging(Criteria cri) throws Exception;	
  
  public List<BoardVO> listSearch(SearchCriteria cri)throws Exception;	//use for dynamic sql
  
  public int listSearchCount(SearchCriteria cri)throws Exception;
  
  public void updateReplyCnt (Integer bno, int amount) throws Exception;	//댓글의 숫자를 변경할 수 있는 aptjem
  
  public void updateViewCnt(Integer bno) throws Exception;
  
  public void addAttach(String fullName) throws Exception;		//첨부파일의 저장경로 저장
  
  public List<String> getAttach(Integer bno) throws Exception;	//특정 게시물의 첨부파일을 시간순으로 가져옴
  
  public void deleteAttach(Integer bno) throws Exception;	//수정작업 시 게시물 삭제
  
  public void replaceAttach(String fullName, Integer bno) throws Exception;	//수정작업 시 게시물 추가
}
