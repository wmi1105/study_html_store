package org.ellen.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.ellen.domain.BoardVO;
import org.ellen.domain.Criteria;
import org.ellen.domain.SearchCriteria;
import org.ellen.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Inject
	private BoardDAO dao;

	@Transactional
	@Override
	public void regist(BoardVO board) throws Exception {
		dao.create(board); // 게시믈 등록

		String[] files = board.getFiles(); // 첨부파일의 이름 배열을 통해서 각각의 파일 이름을
											// 데이터베이스에 추가

		System.out.println("service1 fileName: "+files);
		if (files == null) {
			return;
		}

		System.out.print("service2 fileName: ");
		for (String fileName : files) {
			System.out.print(fileName);
			dao.addAttach(fileName);
		}
	}

	@Override
	public BoardVO read(Integer bno) throws Exception {
		dao.updateViewCnt(bno); // 글 조회수 증가
		return dao.read(bno);
	}

	@Transactional
	@Override
	public void modify(BoardVO board) throws Exception {
		// 게시물을 수정하는 경우 원래의 게시물 수정 + 기존 첨부파일의 목록 삭네+새로운 첨부파일 정보 입력 의 작업이 함께 이뤄져야
		// 함 => 트랜젝션으로 처리
		dao.update(board);

		Integer bno = board.getBno();

		dao.deleteAttach(bno);

		String[] files = board.getFiles();

		if (files == null) {
			return;
		}

		for (String fileName : files) {
			dao.replaceAttach(fileName, bno);
		}
	}

	@Override
	public void remove(Integer bno) throws Exception {
		dao.deleteAttach(bno);
		dao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return dao.listAll();
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {

		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {

		return dao.countPaging(cri);
	}

	@Override
	public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {

		return dao.listSearch(cri);
	}

	@Override
	public int listSearchCount(SearchCriteria cri) throws Exception {

		return dao.listSearchCount(cri);
	}

	@Override
	public List<String> getAttach(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.getAttach(bno);
	}

}
