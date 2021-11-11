package aloha.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import aloha.domain.Board;
import aloha.mapper.BoardMapper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public List<Board> list() throws Exception {
		return mapper.list();
	}

	@Override
	public void insert(Board board) throws Exception {
		
		MultipartFile[] files = board.getFile();
		
		for (MultipartFile file : files) {
			log.info("originalFileName : " + file.getOriginalFilename());
			log.info("contentType : " + file.getContentType());
			log.info("size : " + file.getSize());
		}
		mapper.insert(board);
	}

	@Override
	public Board read(Integer boardNo) throws Exception {
		return mapper.read(boardNo);
	}

	@Override
	public void update(Board board) throws Exception {
		mapper.update(board);
		
	}

	@Override
	public void delete(Integer boardNo) throws Exception {
		mapper.delete(boardNo);
	}

	@Override
	public List<Board> list(String keyword) throws Exception {
		keyword = ( keyword == null ? "" : keyword);

		return mapper.search(keyword);
	}
	
	
}
